package com.manerajona.java.designprinciples.dependencyinjection.dependencymanager;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DependencyManagerImp implements DependencyManager {

    private final Map<Class<?>, Object> dependencies = new ConcurrentHashMap<>();

    public DependencyManagerImp(String... packageNames) {
        Arrays.stream(packageNames)
                .flatMap(packageName -> findClassesInPackage(packageName).stream())
                .filter(clazz -> clazz.isAnnotationPresent(Dependency.class))
                .forEach(this::registerDependency);
    }

    @Override
    public void register(Class<?> type) {
        registerDependency(type);
    }

    @Override
    public <T> T resolve(Class<T> type) {
        Object dependency = dependencies.get(type);
        if (dependency == null) {
            throw new IllegalArgumentException("No dependency found for type: " + type);
        }
        return type.cast(dependency);
    }

    private static Set<Class<?>> findClassesInPackage(String packageName) {
        Set<Class<?>> classes = new HashSet<>();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.', '/');
        URL resource = classLoader.getResource(path);
        if (resource == null) {
            // Package not found; return empty set
            return classes;
        }
        File directory = new File(resource.getFile());
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        if (files == null) {
            return classes;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                classes.addAll(findClassesInPackage(packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
                try {
                    classes.add(Class.forName(className));
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException("Failed to load class: " + className, e);
                }
            }
        }
        return classes;
    }

    private void registerDependency(Class<?> type) {
        // Skip if the dependency is already registered
        if (dependencies.containsKey(type)) {
            return;
        }
        try {
            dependencies.put(type, type.getDeclaredConstructor().newInstance());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException("Failed to register dependency: " + type, e);
        }
    }
}