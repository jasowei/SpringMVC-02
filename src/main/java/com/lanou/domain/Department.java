package com.lanou.domain;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public class Department {
    private String depID;
    private String depName;

    private List<Post> postList;

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }






    public Department() {
    }

    public Department(String depName) {

        this.depName = depName;
    }

    public Department(String depID, String depName) {

        this.depID = depID;
        this.depName = depName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "depID='" + depID + '\'' +
                ", depName='" + depName + '\'' +
                '}';
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }
}
