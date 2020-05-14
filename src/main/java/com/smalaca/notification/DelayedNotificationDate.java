package com.smalaca.notification;

import java.time.LocalDate;
import java.util.Date;

class DelayedNotificationDate {
    private final Date mergeDate;
    private final int daysDelay;

    DelayedNotificationDate(Date mergeDate, int daysDelay) {
        this.mergeDate = mergeDate;
        this.daysDelay = daysDelay;
    }

    LocalDate asLocalDate() {
        int dayOfMonth = mergeDate.getDay() + daysDelay;
        int month = mergeDate.getMonth();
        int year = mergeDate.getYear();

        return LocalDate.of(year, month, dayOfMonth);
    }
}
