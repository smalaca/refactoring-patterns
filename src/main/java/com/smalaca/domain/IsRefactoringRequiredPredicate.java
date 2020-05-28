package com.smalaca.domain;

public class IsRefactoringRequiredPredicate {

    public boolean check(ChangeScope scope, CodeBase codeBase) {
        if (scope.affectedLinesOfCode() <= 100) {
            return false;
        }

        if (scope.numberOfCommits() / ((scope.latestChangeEpochDay() - scope.firstChangeEpochDay()) / 28) < 2) {
            return false;
        }

        if (scope.latestChangeEpochDay() > (codeBase.latestChangeEpochDay() - 84)) {
            return true;
        } else {
            return false;
        }
    }

}
