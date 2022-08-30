package com.springsecurity_app.springboot_auth_jwt_mongo.payload.response

class MessageResponse {
    private int code
    private String message
    private Date timestamp
    private String status

    MessageResponse(int code, String message, String status) {
        this.code = code
        this.message = message
        this.timestamp = new Date()
        this.status = status
    }

    String getMessage() {
        return message
    }

    int getCode() {
        return code
    }

    void setMessage(String message) {
        this.message = message
    }

    void setCode(int code) {
        this.code = code
    }

    Date getTimestamp() {
        return timestamp
    }

    String getStatus() {
        return status
    }

    void setStatus(String status) {
        this.status = status
    }
}
