package com.springsecurity_app.springboot_auth_jwt_mongo.payload.response

class MessageResponse {
    private String message
    private Date timestamp
    private int status

    String getMessage() {
        return message
    }

    void setMessage(String message) {
        this.message = message
    }

    Date getTimestamp() {
        return timestamp
    }

    void setTimestamp(Date timestamp) {
        this.timestamp = timestamp
    }

    int getStatus() {
        return status
    }

    void setStatus(int status) {
        this.status = status
    }

    MessageResponse(int status, String message) {
        this.message = message
        this.timestamp = new Date()
        this.status = status
    }
}
