package com.smalaca.domain;

public class Coverage {
    private long coverage;

    public boolean is(String conditionToCheck, long value) {
        switch (conditionToCheck) {
            case "higher":
                return coverage > value;
            case "equal":
                return coverage == value;
            case "lower":
                return coverage < value;
        }

        throw new IllegalArgumentException("Unsupported condition given: " + conditionToCheck);
    }
}
