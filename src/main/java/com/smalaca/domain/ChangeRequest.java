package com.smalaca.domain;

import java.util.List;

public class ChangeRequest extends PullRequest {
    public ChangeRequest(Author author, String name, List<Commit> commits) {
        super(author, name, commits);
    }
}
