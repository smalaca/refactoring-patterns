package com.smalaca.notification;

public interface NotificationDeltaRepository {
    NotificationDelta findFor(String login);
}
