package com.smalaca.domain;

public class RefactoringProposition {
    private static final int ONE_MONTH = 28;
    private static final int THREE_MONTHS = 84;
    private static final int MINIMAL_COMMITS_NUMBER = 1;

    private final ChangeScope scope;
    private final CodeBase codeBase;

    public RefactoringProposition(ChangeScope scope, CodeBase codeBase) {
        this.scope = scope;
        this.codeBase = codeBase;
    }

    public boolean isRequired() {
        return scope.affectedLinesOfCode() > 100 &&
                averageNumberOfCommits() > MINIMAL_COMMITS_NUMBER &&
                scope.latestChangeEpochDay() > (codeBase.latestChangeEpochDay() - THREE_MONTHS);
    }

    private long averageNumberOfCommits() {
        long periodOfMakingChanges = scope.latestChangeEpochDay() - scope.firstChangeEpochDay();
        long numberOfMonths = periodOfMakingChanges / ONE_MONTH;

        return scope.numberOfCommits() / numberOfMonths;
    }
}
