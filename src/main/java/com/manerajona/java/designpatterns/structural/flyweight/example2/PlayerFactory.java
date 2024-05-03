package com.manerajona.java.designpatterns.structural.flyweight.example2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class PlayerFactory {

    private static final Map<PlayerType, Player> chm = new ConcurrentHashMap<>();

    private PlayerFactory() {
    }

    public static Player getPlayer(PlayerType playerType) {
        Player player;
        if (chm.containsKey(playerType))
            player = chm.get(playerType);
        else {
            player = switch (playerType) {
                case TERRORIST -> new Terrorist();
                case COUNTER_TERRORIST -> new CounterTerrorist();
            };
            chm.put(playerType, player);
            System.out.println(playerType + " created");
        }
        return player;
    }
}
