package com.manerajona.java.designpatterns.behavioral.interpreter;

import java.util.HashMap;
import java.util.Map;

class ExpressionProcessor {
    public Map<Character, java.lang.Integer> variables = new HashMap<>();

    enum NextOp {
        NOTHING, PLUS, MINUS
    }

    public static java.lang.Integer tryParse(String text) {
        try {
            return java.lang.Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public int calculate(String expression) {
        int current = 0;
        NextOp nextOp = NextOp.NOTHING;

        String[] parts = expression.split("(?<=[+-])");

        for (String part : parts) {
            String[] noOp = part.split("[+-]");
            String first = noOp[0];
            int value;

            java.lang.Integer z = tryParse(first);
            if (z != null) {
                value = z.intValue();
            } else if (first.length() == 1
                    && variables.containsKey(first.charAt(0))) {
                value = variables.get(first.charAt(0));
            } else return 0;

            switch (nextOp) {
                case NOTHING:
                    current = value;
                    break;
                case PLUS:
                    current += value;
                    break;
                case MINUS:
                    current -= value;
                    break;
            }

            if (part.endsWith("+")) nextOp = NextOp.PLUS;
            else if (part.endsWith("-")) nextOp = NextOp.MINUS;
        }
        return current;
    }
}