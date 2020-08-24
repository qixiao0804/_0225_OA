package com.qx.service;


import com.qx.model.Sign;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


import java.util.List;

public interface SignService {

    //签到表查询

//    List<Sign> selectBySign(Sign sign)throws Exception;


    @Select("select * from sign where uid =#{id}")
    Sign selectByName(Sign sign)throws Exception;


    //打卡

    int insertBySign(Sign sign)throws Exception;


    List<Sign> selectBypage(Sign sign,int page,int limit)throws Exception;
    List<Sign> selectBypage1(Sign sign,int page,int limit)throws Exception;
}
