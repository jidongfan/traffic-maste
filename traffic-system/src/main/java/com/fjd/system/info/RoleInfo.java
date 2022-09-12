package com.fjd.system.info;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_role")
public class RoleInfo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long rid;
  @Column(name = "rname")
  private String rname;
  @Column(name = "rtype")
  private int rtype;
  @Column(name = "rdesc")
  private String rdesc;

  @ManyToMany(mappedBy = "roles")  //指定跟roles关联起来，配置一边就可以了
  private List<UserInfo> users;

  public long getRid() {
    return rid;
  }

  public void setRid(long rid) {
    this.rid = rid;
  }

  public String getRname() {
    return rname;
  }

  public void setRname(String rname) {
    this.rname = rname;
  }

  public int getRtype() {
    return rtype;
  }

  public void setRtype(int rtype) {
    this.rtype = rtype;
  }

  public String getRdesc() {
    return rdesc;
  }

  public void setRdesc(String rdesc) {
    this.rdesc = rdesc;
  }

  public List<UserInfo> getUsers() {
    return users;
  }

  public void setUsers(List<UserInfo> users) {
    this.users = users;
  }
}
