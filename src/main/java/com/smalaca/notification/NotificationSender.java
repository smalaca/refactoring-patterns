package com.smalaca.notification;

import com.smalaca.domain.PullRequest;

public interface NotificationSender {
    void notify(PullRequest pullRequest);

    void notify(String message, String receiver);
}
