package com.smalaca.services;

import com.smalaca.domain.Commit;
import com.smalaca.domain.CommitRepository;
import com.smalaca.domain.History;

public class CommitService {
    private final History history;
    private final CommitRepository commitRepository;

    public CommitService(History history, CommitRepository commitRepository) {
        this.history = history;
        this.commitRepository = commitRepository;
    }

    public void save(Commit commit) {
        history.store(commit.getAuthor().getLogin(), commit);
        commitRepository.save(commit);
    }
}
