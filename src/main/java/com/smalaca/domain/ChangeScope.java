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
        int linesOfCode = finalCode.stream().mapToInt(CodeClass::linesOfCode).sum();
        linesOfCode -= initialCode.stream().mapToInt(CodeClass::linesOfCode).sum();

        return linesOfCode;
    }

    public int numberOfCommits() {
        return commits.size();
    }

    public long latestChangeEpochDay() {
        Optional<Commit> latestCommit = commits.stream().min(Comparator.comparing(Commit::creationEpochDay));

        if (latestCommit.isPresent()) {
            return latestCommit.get().creationEpochDay();
        }

        return -1;
    }

    public long firstChangeEpochDay() {
        Optional<Commit> latestCommit = commits.stream().max(Comparator.comparing(Commit::creationEpochDay));

        if (latestCommit.isPresent()) {
            return latestCommit.get().creationEpochDay();
        }

        return -1;
    }
}
