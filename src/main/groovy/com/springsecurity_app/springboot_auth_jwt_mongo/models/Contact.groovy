package com.springsecurity_app.springboot_auth_jwt_mongo.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "contacts")
class Contact {
    @Id
    private String id

    @Field(name = "contact_name")
    private String contactName

    @Field(name = "contact_email")
    private String contactEmail

    private String subject

    private String message

    @Field(name = "create_at")
    private Date createDt

     String getContactId() {
        return contactId
    }

     void setContactId(String contactId) {
        this.contactId = contactId
    }

     String getContactName() {
        return contactName
    }

     void setContactName(String contactName) {
        this.contactName = contactName
    }

     String getContactEmail() {
        return contactEmail
    }

     void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail
    }

     String getSubject() {
        return subject
    }

     void setSubject(String subject) {
        this.subject = subject
    }

     String getMessage() {
        return message
    }

     void setMessage(String message) {
        this.message = message
    }

     Date getCreateDt() {
        return createDt
    }

     void setCreateDt(Date createDt) {
        this.createDt = createDt
    }
}
