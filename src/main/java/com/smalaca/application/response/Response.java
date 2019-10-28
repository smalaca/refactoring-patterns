package com.smalaca.application.response;

public class Response {
    private final boolean isSuccess;

    private Response(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public static Response failure() {
        return new Response(false);
    }

    public static Response success() {
        return new Response(true);
    }
}
