package com.qx.service;

import com.qx.model.Email;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmailService {



    //查看邮件

//    List<Email> selectByAll()throws Exception;

    //发送邮件

    int insertByEmail(Email email)throws Exception;

    //删除邮件

    int deleteByEmail(Integer id);

    //查看邮件

    List<Email> selectByPage(int page,int limit)throws Exception;
}
