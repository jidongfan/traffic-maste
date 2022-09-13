package com.fjd.web.user.entity;

import com.sun.xml.internal.ws.developer.UsesJAXBContext;

import javax.persistence.*;

@Entity
@Table(name = "user_info")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_pass")
    private String userPass;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                //", uerPass='" + uerPass + '\'' +
                '}';
    }
}
