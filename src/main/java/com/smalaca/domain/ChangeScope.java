package com.smalaca.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ChangeScope {
    private final int linesOfCode;
    private final List<CodeClass> initialCode;
    private final List<CodeClass> finalCode;
    private final List<Commit> commits;

    public ChangeScope(int linesOfCode, List<CodeClass> initialCode, List<CodeClass> finalCode, List<Commit> commits) {
        this.linesOfCode = linesOfCode;
        this.initialCode = initialCode;
        this.finalCode = finalCode;
        this.commits = commits;
    }

    public int affectedLinesOfCode() {
        return linesOfCodeAfterChange() - linesOfCodeBeforeChange();
    }

    private int linesOfCodeBeforeChange() {
        return initialCode.stream().mapToInt(CodeClass::linesOfCode).sum();
    }

    private int linesOfCodeAfterChange() {
        return finalCode.stream().mapToInt(CodeClass::linesOfCode).sum();
    }

    public int numberOfCommits() {
        return commits.size();
    }

    public long latestChangeEpochDay() {
        if (latestCommitExists()) {
            return creationEpochDayOfLatestCommit();
        }

        return -1;
    }

    private long creationEpochDayOfLatestCommit() {
        return latestCommit().get().creationEpochDay();
    }

    private boolean latestCommitExists() {
        return latestCommit().isPresent();
    }

    private Optional<Commit> latestCommit() {
        return commits.stream().min(Comparator.comparing(Commit::creationEpochDay));
    }

    public long firstChangeEpochDay() {
        Optional<Commit> latestCommit = commits.stream().max(Comparator.comparing(Commit::creationEpochDay));

        if (latestCommit.isPresent()) {
            return latestCommit.get().creationEpochDay();
        }

        return -1;
    }
}
