package com.example.hotel2.exeptions;

public class ErrorObject {

    private int status;

    private String message;

    private long timestamp;

    public int getHttpCodeMessage() {
        return httpCodeMessage;
    }

    public void setHttpCodeMessage(int httpCodeMessage) {
        this.httpCodeMessage = httpCodeMessage;
    }

    private int httpCodeMessage;




    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public ErrorObject() {
    }

    public ErrorObject(int status, String message, long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }



}
