package com.smalaca.services;

import com.smalaca.domain.*;

import java.time.LocalDate;

public class CommitService {
    private final History history;
    private final CommitRepository commitRepository;

    public CommitService(History history, CommitRepository commitRepository) {
        this.history = history;
        this.commitRepository = commitRepository;
    }

    public void create(Author author, CodeBaseDelta codeBaseDelta, LocalDate creationDate, String taskNumber, String description) {
        Commit commit = new Commit(creationDate, author, codeBaseDelta, new String[]{taskNumber, description});

        history.store(commit.getAuthor().getLogin(), commit);
        commitRepository.save(commit);
    }
}
