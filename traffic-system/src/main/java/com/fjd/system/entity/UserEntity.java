package com.fjd.system.entity;

import java.util.Date;

/**
 * 前端传过来的实体类
 */
public class UserEntity {

    private long uid;
    private String uname;
    private String uaccount;
    private String upass;
    private String uemail;
    private String uphone;
    private String udesc;
    private String u1;

    //在查询功能的时候会使用到
    private Date startTime;
    private Date endTime;


    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }


    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }


    public String getUaccount() {
        return uaccount;
    }

    public void setUaccount(String uaccount) {
        this.uaccount = uaccount;
    }


    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }


    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }


    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }


    public String getUdesc() {
        return udesc;
    }

    public void setUdesc(String udesc) {
        this.udesc = udesc;
    }


    public String getU1() {
        return u1;
    }

    public void setU1(String u1) {
        this.u1 = u1;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", uaccount='" + uaccount + '\'' +
               // ", upass='" + upass + '\'' +
                ", uemail='" + uemail + '\'' +
                ", uphone='" + uphone + '\'' +
                ", udesc='" + udesc + '\'' +
                ", u1='" + u1 + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}