package com.smalaca.domain;

public class RefactoringProposition {
    private static final int DAYS_IN_FOUR_WEEKS_PERIOD = 28;
    private final ChangeScope scope;
    private final CodeBase codeBase;

    public RefactoringProposition(ChangeScope scope, CodeBase codeBase) {
        this.scope = scope;
        this.codeBase = codeBase;
    }

    public boolean isRequired() {
        return moreThanHundredAffectedLinesOfCode() &&
                averageNumberOfCommits() > 1 &&
                scope.latestCommitEpochDay() > (codeBase.latestChangeEpochDay() - 84);
    }

    private boolean moreThanHundredAffectedLinesOfCode() {
        return scope.affectedLinesOfCode() > 100;
    }

    private long averageNumberOfCommits() {
        long averageNumberOfChangesPerPeriod = (scope.latestCommitEpochDay() - scope.firstCommitEpochDay()) / DAYS_IN_FOUR_WEEKS_PERIOD;
        return scope.numberOfCommits() / averageNumberOfChangesPerPeriod;
    }
}
