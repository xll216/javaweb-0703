package com.lanou.crm.hr.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class Department implements Serializable {
    private int depID;//主键 ID
    private String depName;//部门名称
    /*一个部门对应多个职务 一对多双向*/
    private Set<Post> postSet = new HashSet<>();

    public int getDepID() {
        return depID;
    }

    public void setDepID(int depID) {
        this.depID = depID;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public Set<Post> getPostSet() {
        return postSet;
    }

    public void setPostSet(Set<Post> postSet) {
        this.postSet = postSet;
    }

    @Override
    public String toString() {
        return "Department{" +
                "depID=" + depID +
                ", depName='" + depName + '\'' +
                '}';
    }
}
