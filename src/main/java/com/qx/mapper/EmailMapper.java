package com.qx.mapper;

import com.qx.model.Email;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmailMapper {

//    //查看邮件
//    @Select("select * from email ")
//    List<Email> selectByAll()throws Exception;

    @Select("select * from email where id = #{id}")
    Email selectById(Email email);

    //发送邮件
    @Insert("insert into email(title,content,createDate,attachment,uid) values(#{title},#{content},#{createDate},#{attachment},#{uid})")
    int insertByEmail(Email email)throws Exception;

    //删除邮件
    @Delete("delete from email where uid=#{id}")
//    @Delete("delete from email where  uid=#{id}")
    int deleteByUid(Integer id);


    //删除邮件
    @Delete("delete from email where id=#{id}")
//    @Delete("delete from email where  id=#{id}")
    int deleteByEmail(Integer id);

    //查看邮件
    @Select("select * from email ")
    List<Email> selectByAll()throws Exception;

}
