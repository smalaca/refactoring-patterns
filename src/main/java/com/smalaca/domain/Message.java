package com.smalaca.domain;

public class Message {
    private final String taskNumber;
    private final String description;

    public Message(String taskNumber, String description) {
        this.taskNumber = taskNumber;
        this.description = description;
    }

    String value() {
        return taskNumber + " - " + description;
    }
}
