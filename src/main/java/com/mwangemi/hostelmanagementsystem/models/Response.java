package com.mwangemi.hostelmanagementsystem.models;

public class Response {
    private String text;

    public Response(String text) {
        this.text = text;
    }

    public Response() {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
