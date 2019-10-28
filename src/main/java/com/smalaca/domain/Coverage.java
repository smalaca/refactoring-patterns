package com.smalaca.domain;

public class Coverage {
    private long coverage;

    public boolean is(String conditionToCheck, long value) {
        switch (conditionToCheck) {
            case "higher":
                return isHigher(value);
            case "equal":
                return isEqual(value);
            case "lower":
                return isLower(value);
        }

        throw new IllegalArgumentException("Unsupported condition given: " + conditionToCheck);
    }

    private boolean isLower(long value) {
        return coverage < value;
    }

    private boolean isEqual(long value) {
        return coverage == value;
    }

    private boolean isHigher(long value) {
        return coverage > value;
    }
}
