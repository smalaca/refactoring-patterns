package com.smalaca.domain;

public class RefactoringProposition {
    private final ChangeScope scope;
    private final CodeBase codeBase;

    public RefactoringProposition(ChangeScope scope, CodeBase codeBase) {
        this.scope = scope;
        this.codeBase = codeBase;
    }

    public boolean isRequired() {
        return moreThanHundredAffectedLinesOfCode() &&
                averageNumberOfCommits() > 1 &&
                scope.latestChangeEpochDay() > (codeBase.latestChangeEpochDay() - 84);
     }

    private boolean moreThanHundredAffectedLinesOfCode() {
        return scope.affectedLinesOfCode() > 100;
    }

    private long averageNumberOfCommits() {
        return scope.numberOfCommits() / (scope.latestChangeEpochDay() - scope.firstChangeEpochDay() / 28);
    }
}
