package com.smalaca.domain;

class Message {
    private final String taskNumber;
    private final String description;

    Message(String taskNumber, String description) {
        this.taskNumber = taskNumber;
        this.description = description;
    }

    String value() {
        return taskNumber + " - " + description;
    }
}
