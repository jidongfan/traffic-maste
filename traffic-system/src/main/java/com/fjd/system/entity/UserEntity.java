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
    private Date utime;

    //在查询功能更的时候会使用到
    //和前端约定 1.时间戳 55211021 默认  2.字符串日期 2000/02/02
    private String startTime;
    private String endTime;

    private int currentPage = 0; //当前页；JPA默认值是从0开始

    private int pageSize = 3; //每页记录数

    //假设做两个组合，如果不写，默认是按照主键排
    private String sort; //组合排序规则；utime，uaccount

    //排序类型
    private String sortType = "ASC";

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

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
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