package com.smalaca.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.mockito.Mockito.mock;

class CommitTest {
    @Test
    void shouldReturnMessage() {
        String hashCode = UUID.randomUUID().toString();
        LocalDate creationDate = LocalDate.now();
        Author author = mock(Author.class);
        CodeBaseDelta codeBaseDelta = mock(CodeBaseDelta.class);
        String[] message = new String[]{"number", "title"};

        Commit commit = new Commit(hashCode, creationDate, author, codeBaseDelta, new Message(message[0], message[1]));

        Assertions.assertThat(commit.message()).isEqualTo("number - title");
    }
}