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
        Date mergeDate = pullRequest.getMergeDate();
        int dayOfMonth = mergeDate.getDay() + delta.getDaysDelay();
        int month = mergeDate.getMonth();
        int year = mergeDate.getYear();

        LocalDate delayed = LocalDate.of(year, month, dayOfMonth);

        send(pullRequest, login, delayed);
    }

    private void send(PullRequest pullRequest, String login, LocalDate delayed) {
        // to implement
    }

    public void notify(String message, String receiver) {
        // to implement
    }
}
