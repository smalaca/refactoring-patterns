package com.smalaca.domain;

import java.time.LocalDate;

public class History {
    public void store(CodeChange codeChange) {

    }

    public void store(Author author, ChangeScope scope, CodeBaseDelta codeBaseDelta, Justification justification, LocalDate date) {
        store(new CodeChange(author, scope, codeBaseDelta, justification, date));
    }

    public void store(String login, Commit commit) {

    }
}
