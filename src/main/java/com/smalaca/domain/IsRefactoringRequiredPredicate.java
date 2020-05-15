package com.smalaca.domain;

public class IsRefactoringRequiredPredicate {

    public boolean check(ChangeScope scope, CodeBase codeBase) {
        if (!hasNotEnoughAffectedLinesOfCode(scope)) {
            if (!hasNotEnoughAverageCommitsPerMonth(scope)) {
                return isLatestCommitNotOlderThanThreeMonths(scope, codeBase);
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    private boolean isLatestCommitNotOlderThanThreeMonths(ChangeScope scope, CodeBase codeBase) {
        return scope.latestChangeEpochDay() > (codeBase.latestChangeEpochDay() - 84);
    }

    private boolean hasNotEnoughAverageCommitsPerMonth(ChangeScope scope) {
        return scope.numberOfCommits() / ((scope.latestChangeEpochDay() - scope.firstChangeEpochDay()) / 28) < 2;
    }

    private boolean hasNotEnoughAffectedLinesOfCode(ChangeScope scope) {
        return scope.affectedLinesOfCode() <= 100;
    }

}
