package com.qx.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Sign {
    private  int id;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime;

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime2;

    private int flag;
    private  Integer uid;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getCreatetime2() {
        return createtime2;
    }

    public void setCreatetime2(Date createtime2) {
        this.createtime2 = createtime2;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public int getFlag() {
        return flag;
    }
}
