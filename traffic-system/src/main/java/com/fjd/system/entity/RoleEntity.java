package com.fjd.system.entity;


public class RoleEntity {

  private long rid;
  private String rname;
  private int rtype;
  private String rdesc;


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

}