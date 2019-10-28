package com.smalaca.notification;

public class NotificationDelta {
    private final int daysDelay;

    public NotificationDelta(int daysDelay) {
        this.daysDelay = daysDelay;
    }

    public int getDaysDelay() {
        return daysDelay;
    }
}
