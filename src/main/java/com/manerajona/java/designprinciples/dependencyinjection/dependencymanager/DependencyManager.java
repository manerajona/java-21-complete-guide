package com.manerajona.java.designprinciples.dependencyinjection.dependencymanager;

public interface DependencyManager {
    void register(Class<?> type);

    <T> T resolve(Class<T> type);
}