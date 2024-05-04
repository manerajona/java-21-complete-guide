package com.manerajona.java.designpatterns.structural.proxy.example2;

import java.util.HashSet;
import java.util.Set;

class Firewall implements Internet {

    private final Internet internet = new Wireless();

    private static final Set<String> banned;
    static {
        banned = new HashSet<>();
        banned.add("hackers.com");
        banned.add("danger.com");
        banned.add("forbidden.io");
        banned.add("stealing.org");
    }

    @Override
    public void connectTo(String serverHost) throws ForbiddenException {
        if (banned.contains(serverHost.toLowerCase())) {
            throw new ForbiddenException("Access Denied");
        }
        internet.connectTo(serverHost);
    }
}
