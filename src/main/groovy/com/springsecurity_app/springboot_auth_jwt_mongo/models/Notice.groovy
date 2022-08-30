package com.springsecurity_app.springboot_auth_jwt_mongo.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "notices")
class Notice {
    @Id
    private String id

    @Field(name = "notice_summary")
    private String noticeSummary

    @Field(name = "notice_details")
    private String noticeDetails

    @Field(name = "notic_beg_dt")
    private Date noticBegDt

    @Field(name = "notic_end_dt")
    private Date noticEndDt

    @Field(name = "create_dt")
    private Date createDt

    @Field(name = "update_dt")
    private Date updateDt

    int getNoticeId() {
        return noticeId
    }

    void setNoticeId(int noticeId) {
        this.noticeId = noticeId
    }

    String getNoticeSummary() {
        return noticeSummary
    }

    void setNoticeSummary(String noticeSummary) {
        this.noticeSummary = noticeSummary
    }

    String getNoticeDetails() {
        return noticeDetails
    }

    void setNoticeDetails(String noticeDetails) {
        this.noticeDetails = noticeDetails
    }

    Date getNoticBegDt() {
        return noticBegDt
    }

    void setNoticBegDt(Date noticBegDt) {
        this.noticBegDt = noticBegDt
    }

    Date getNoticEndDt() {
        return noticEndDt
    }

    void setNoticEndDt(Date noticEndDt) {
        this.noticEndDt = noticEndDt
    }

    Date getCreateDt() {
        return createDt
    }

    void setCreateDt(Date createDt) {
        this.createDt = createDt
    }

    Date getUpdateDt() {
        return updateDt
    }

    void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt
    }
}
