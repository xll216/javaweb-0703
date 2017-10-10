package com.lanou.crm.hr.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 * 职务表
 */
public class Post implements Serializable{
    private int postId;//主键 ID
    private String postName;//职务名称

    /*一个部门对应多个职务 一对多双向*/
    private Department department;//部门 ID

    /*一个职务对应多个职务 一对多双向*/
    private Set<Staff> staffSet = new HashSet<>();

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Staff> getStaffSet() {
        return staffSet;
    }

    public void setStaffSet(Set<Staff> staffSet) {
        this.staffSet = staffSet;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postName='" + postName + '\'' +
                '}';
    }
}
