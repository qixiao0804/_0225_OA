package com.qx.service;

import com.qx.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserService {

    //登录
    User findByLogin(String loginname, String password)throws Exception;


//    List<User> findAll(User user,int page,int limit)throws  Exception;

//    List<User> findPage(int pageNum,int pageSize) throws Exception;

    List<User> selectByLike(User user,int page,int limit)throws Exception;

    int updateByUser(User user) throws Exception;


    int addUser(User user) throws Exception;

    //用户删除

    int deleteByUser(int id)throws Exception;
    int deleteByAll(String sID)throws Exception;



    //报表用户
    User selectByName(User user)throws Exception;

}
