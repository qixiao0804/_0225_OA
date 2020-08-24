package com.qx.mapper;

import com.qx.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserMapper {

    //登录
    @Select("select * from user where loginname =#{loginname} and password =#{password}")
    User selectByLogin(@Param("loginname") String loginname, @Param("password") String password)throws Exception;

    //用户查询
//    @Select("select * from user")
//    List<User> selectAll()throws Exception;


    //用户模糊查询
    @Select("<script>select * from user <where> " +
            "<if test=\"username !=null and username!='' \">username = #{username} </if>  " +
            "<if test=\"status !=null and status>=0\"> and status = #{status} </if>" +
            "<if test=\"loginname !=null and loginname !=''\"> or loginname = #{loginname} </if>" +
            "</where> </script>")
    List<User> selectByLike(User user)throws Exception;


    //用户修改

    @Update("update user set username=#{username}, status =#{status} ,loginname=#{loginname}, password=#{password} where id = #{id} ")
    int updateByUser(User user) throws Exception;


    //用户添加
    @Insert("insert into user(username,status,loginname,password,createDate) values(#{username},#{status},#{loginname},#{password},#{createDate})")
    int insertUser(User user) throws Exception;

    //用户删除

    @Delete("delete from user where id=#{id}")
    int deleteByUser(int id)throws Exception;


    //报表用户
        @Select("select * from user where username =#{username}")
    User selectByName(User user)throws Exception;






}
