package com.lanou.crm.refer.domain;

import java.util.Date;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class Follow {
    private int followId;//主键 ID
    private Date followTime;//跟踪时间
    private String content;//内容
    private String staffID;//营销人员(从 Session 中获取)，当前 登录人的 ID
    private String referID;//学生咨询表的主键 ID

    public int getFollowId() {
        return followId;
    }

    public void setFollowId(int followId) {
        this.followId = followId;
    }

    public Date getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getReferID() {
        return referID;
    }

    public void setReferID(String referID) {
        this.referID = referID;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "followId=" + followId +
                ", followTime=" + followTime +
                ", content='" + content + '\'' +
                ", staffID='" + staffID + '\'' +
                ", referID='" + referID + '\'' +
                '}';
    }
}
