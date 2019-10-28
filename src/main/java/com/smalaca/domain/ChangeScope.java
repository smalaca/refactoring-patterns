package com.smalaca.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ChangeScope {
    private final String id;
    private final int linesOfCode;
    private final List<CodeClass> initialCode;
    private final List<CodeClass> finalCode;
    private final List<Commit> commits;

    public ChangeScope(String id, int linesOfCode, List<CodeClass> initialCode, List<CodeClass> finalCode, List<Commit> commits) {
        this.id = id;
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

    public long latestCommitEpochDay() {
        Optional<Commit> latestCommit = commits.stream().min(Comparator.comparing(Commit::creationEpochDay));

        if (latestCommit.isPresent()) {
            return latestCommit.get().creationEpochDay();
        }

        throw CommitNotPresentException.latest(id);
    }

    public long firstCommitEpochDay() {
        if (latestCommit().isPresent()) {
            return latestCommit().get().creationEpochDay();
        }

        throw CommitNotPresentException.first(id);
    }

    private Optional<Commit> latestCommit() {
        return commits.stream().max(Comparator.comparing(Commit::creationEpochDay));
    }
}
