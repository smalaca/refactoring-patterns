package com.smalaca.domain;

public class RefactoringJustification {
    private final String name;
    private String description;
    private TaskLink link;

    public RefactoringJustification(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLink(TaskLink link) {
        this.link = link;
    }
}
