package com.smalaca.domain;

import java.util.List;

public class Improvement extends PullRequest {
    public Improvement(Author author, String name, List<Commit> commits) {
        super(author, name, commits);
    }

    public void alterWith(CommitAmend amend) {
        getCommits().stream().filter(commit -> commit.hasSameHashCodeAs(amend)).findFirst().get().getCodeBaseDelta().change(amend.getCodeBaseDelta());
    }
}
