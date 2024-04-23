package com.manerajona.java.designpatterns.creationals.prototype.example2;

import java.util.HashMap;
import java.util.Map;

public class BasicCarCache {
    private static final Map<String, BasicCar> basicCarMap = new HashMap<>();

    private BasicCarCache() {
    }

    public static BasicCar getCar(String carName) {
        BasicCar cachedBasicCar = basicCarMap.get(carName);
        return cachedBasicCar.clone();
    }

    public static void loadCache() {
        BasicCar nano_base = new Nano("Green Nano");
        nano_base.setPrice(100_000);
        basicCarMap.put("Green Nano", nano_base);

        BasicCar ford_basic = new Ford("Ford Yellow");
        ford_basic.setPrice(500_000);
        basicCarMap.put("Ford Yellow", ford_basic);
    }
}
