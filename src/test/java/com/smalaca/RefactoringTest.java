package com.smalaca;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RefactoringTest {
    @Test
    void shouldTellRefactoringIsFun() {
        Refactoring refactoring = new Refactoring();

        assertThat(refactoring.isFun()).isTrue();
    }

    private static class Refactoring {
        boolean isFun() {
            return true;
        }
    }
}
