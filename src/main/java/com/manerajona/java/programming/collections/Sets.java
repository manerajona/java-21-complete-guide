package com.manerajona.java.programming.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Sets {

    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        HeavenlyBody temp = new HeavenlyBody("Mercury", 88);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Venus", 225);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Earth", 365);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new HeavenlyBody("Moon", 27);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        temp = new HeavenlyBody("Mars", 687);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Deimos", 1.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        tempMoon = new HeavenlyBody("Phobos", 0.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        temp = new HeavenlyBody("Jupiter", 4332);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Io", 1.8);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new HeavenlyBody("Europa", 3.5);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new HeavenlyBody("Ganymede", 7.1);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new HeavenlyBody("Callisto", 16.7);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        temp = new HeavenlyBody("Saturn", 10759);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Uranus", 30660);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Neptune", 165);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Pluto", 248);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        System.out.println("Planets");
        planets.stream().map(planet -> "\t" + planet.getName()).forEach(System.out::println);

        HeavenlyBody body = solarSystem.get("Mars");
        System.out.println("Moons of " + body.getName());
        body.getSatellites().stream().map(jupiterMoon -> "\t" + jupiterMoon.getName()).forEach(System.out::println);

        Set<HeavenlyBody> moons = new HashSet<>();
        planets.stream().map(HeavenlyBody::getSatellites).forEach(moons::addAll);

        System.out.println("All Moons");
        moons.stream().map(moon -> "\t" + moon.getName()).forEach(System.out::println);

        HeavenlyBody pluto = new HeavenlyBody("Pluto", 842);
        planets.add(pluto);
        pluto = new HeavenlyBody("Pluto", 842);
        planets.add(pluto);
        pluto = new HeavenlyBody("pluto", 842);
        planets.add(pluto);
        pluto = new HeavenlyBody("PLUTO", 842);
        planets.add(pluto);

        planets.forEach(s -> System.out.println(s.getName()));
    }


    private final static class HeavenlyBody {
        private final String name;
        private final double orbitalPeriod;
        private final Set<HeavenlyBody> satellites;

        public HeavenlyBody(String name, double orbitalPeriod) {
            this.name = name;
            this.orbitalPeriod = orbitalPeriod;
            this.satellites = new HashSet<>();
        }

        public String getName() {
            return name;
        }

        public double getOrbitalPeriod() {
            return orbitalPeriod;
        }

        public boolean addMoon(HeavenlyBody moon) {
            return this.satellites.add(moon);
        }

        public Set<HeavenlyBody> getSatellites() {
            return new HashSet<>(satellites);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof HeavenlyBody)) return false;
            HeavenlyBody that = (HeavenlyBody) o;
            return Objects.equals(getName(), that.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getName());
        }
    }
}
