package com.smalaca.services;

import com.smalaca.domain.*;

import java.time.LocalDate;

class HistoryClient {
    private final History history;

    HistoryClient(History history) {
        this.history = history;
    }

    public void store(Author author, ChangeScope scope, CodeBaseDelta codeBaseDelta, Justification justification, LocalDate date) {
        CodeChange codeChange = new CodeChange(author, scope, codeBaseDelta, justification, date);
        // some instructions

        history.store(codeChange);
        // more instructions
    }
}
