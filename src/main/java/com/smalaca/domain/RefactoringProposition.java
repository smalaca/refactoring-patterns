package com.smalaca.domain;

public class RefactoringProposition {
    private final ChangeScope scope;
    private final CodeBase codeBase;

    public RefactoringProposition(ChangeScope scope, CodeBase codeBase) {
        this.scope = scope;
        this.codeBase = codeBase;
    }

    public boolean isRequired() {
        return scope.affectedLinesOfCode() > 100 &&
                averageNumberOfCommits() > 1 &&
                scope.latestChangeEpochDay() > (codeBase.latestChangeEpochDay() - 84);
     }

    private long averageNumberOfCommits() {
        long periodOfMakingChanges = scope.latestChangeEpochDay() - scope.firstChangeEpochDay();
        long numberOfMonths = periodOfMakingChanges / 28;

        return scope.numberOfCommits() / numberOfMonths;
    }
}
