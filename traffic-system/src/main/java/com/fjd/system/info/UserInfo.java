package com.fjd.system.info;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 这里的entity是和前端页面交互的，info是和数据交互
 */
@Entity
@Table(name = "t_user")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uid;
    @Column(name = "uname")//数据表字段
    private String uname;
    @Column(name = "uaccount")
    private String uaccount;
    @Column(name = "upass")
    private String upass;
    @Column(name = "uemail")
    private String uemail;
    @Column(name = "uphone")
    private String uphone;
    @Column(name = "udesc")
    private String udesc;
    @Column(name = "u1")
    private String u1;

    @Column(name = "utime")
    private Date utime;

    //用于标注该条数据是否被删除
    @Column(name = "ustatus")
    private int ustatus;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "t_user_role",
            joinColumns = {
            //当前的实体类的名字，表字段的名称
                @JoinColumn(name = "uid", referencedColumnName = "uid")
            },
            inverseJoinColumns = {
            //目标的实体类 roleInfo
                @JoinColumn(name = "rid", referencedColumnName = "rid")
            }
    )
    private List<RoleInfo> roles;


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

    public int getUstatus() {
        return ustatus;
    }

    public void setUstatus(int ustatus) {
        this.ustatus = ustatus;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    public List<RoleInfo> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleInfo> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", uaccount='" + uaccount + '\'' +
               // ", upass='" + upass + '\'' +
                ", uemail='" + uemail + '\'' +
                ", uphone='" + uphone + '\'' +
                ", udesc='" + udesc + '\'' +
                ", u1='" + u1 + '\'' +
                '}';
    }
}