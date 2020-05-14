package com.smalaca.notification;

import com.smalaca.domain.PullRequest;

import java.time.LocalDate;
import java.util.Date;

public class MailNotificationSender implements NotificationSender{
    private final NotificationDeltaRepository repository;

    public MailNotificationSender(NotificationDeltaRepository repository) {
        this.repository = repository;
    }

    public void notify(PullRequest pullRequest) {
        send(pullRequest, pullRequest.getAuthor().getLogin());

        pullRequest.getReviewers().forEach(reviewer -> send(pullRequest, reviewer.getLogin()));
    }

    private void send(PullRequest pullRequest, String login) {
        NotificationDelta delta = repository.findFor(login);
        LocalDate delayed = getDelayedNotificationDate(pullRequest.getMergeDate(), delta.getDaysDelay());

        send(pullRequest, login, delayed);
    }

    private LocalDate getDelayedNotificationDate(Date mergeDate, int daysDelay) {
        return new DelayedNotificationDate(mergeDate, daysDelay).asLocalDate();
    }

    private void send(PullRequest pullRequest, String login, LocalDate delayed) {
        // to implement
    }

    public void notify(String message, String receiver) {
        // to implement
    }
}
