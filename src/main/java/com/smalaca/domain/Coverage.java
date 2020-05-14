package com.smalaca.domain;

public class Coverage {
    private long coverage;

    public boolean isHigherThan(long value) {
        return coverage > value;
    }

    public boolean isEqualTo(long value) {
        return coverage == value;
    }

    public boolean isLowerThan(long value) {
        return coverage < value;
    }
}
