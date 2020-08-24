package com.qx.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Inform {
    private int id;
    private  String title;
    private  String content;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date createDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
