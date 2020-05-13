package com.smalaca.services;

import com.smalaca.domain.*;

import java.time.LocalDate;
import java.util.UUID;

public class CommitService {
    private final History history;
    private final CommitRepository commitRepository;

    public CommitService(History history, CommitRepository commitRepository) {
        this.history = history;
        this.commitRepository = commitRepository;
    }

    public void create(Author author, CodeBaseDelta codeBaseDelta, LocalDate creationDate, String taskNumber, String description) {
        String hashCode = UUID.randomUUID().toString();
        Commit commit = new Commit(hashCode, creationDate, author, codeBaseDelta, new String[]{taskNumber, description});

        history.store(commit.getAuthor().getLogin(), commit);
        commitRepository.save(commit);
    }
}
