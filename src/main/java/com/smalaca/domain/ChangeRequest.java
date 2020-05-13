package com.smalaca.domain;

import java.util.List;

public class ChangeRequest extends PullRequest {
    public ChangeRequest(Author author, String name, List<Commit> commits) {
        super(author, name, commits);
    }

    public void amend(CommitAmend amend) {
        for (Commit commit : getCommits()) {
            if (commit.hasSameHashCodeAs(amend)) {
                CodeBaseDelta codeBaseDelta = commit.getCodeBaseDelta();
                CodeBaseDelta newCodeBaseDelta = amend.getCodeBaseDelta();
                codeBaseDelta.change(newCodeBaseDelta);
            }
        }
    }
}
