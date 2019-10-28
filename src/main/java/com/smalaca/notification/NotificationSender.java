package com.smalaca.notification;

import com.smalaca.domain.PullRequest;

import java.time.LocalDate;
import java.time.Month;

public class NotificationSender {
    private final NotificationDeltaRepository repository;

    public NotificationSender(NotificationDeltaRepository repository) {
        this.repository = repository;
    }

    public void notify(PullRequest pullRequest) {
        send(pullRequest, pullRequest.getAuthor().getLogin());

        pullRequest.getReviewers().forEach(reviewer -> send(pullRequest, reviewer.getLogin()));
    }

    private void send(PullRequest pullRequest, String login) {
        NotificationDelta delta = repository.findFor(login);
        LocalDate delayed = withDelay(pullRequest.getMergeDate(), delta);

        send(pullRequest, login, delayed);
    }

    private void send(PullRequest pullRequest, String login, LocalDate delayed) {
        // to implement
    }

    private LocalDate withDelay(LocalDate mergeDate, NotificationDelta delta) {
        int dayOfMonth = mergeDate.getDayOfMonth() - delta.getDaysDelay();
        Month month = mergeDate.getMonth();
        int year = mergeDate.getYear();

        return LocalDate.of(year, month, dayOfMonth);
    }
}
