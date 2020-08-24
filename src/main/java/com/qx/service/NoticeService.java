package com.qx.service;

import com.qx.model.Department;
import com.qx.model.Inform;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface NoticeService {


    //公告查找  模糊查询

//    List<Inform> selectAll(Inform inform)throws Exception;


    //公告更改

    int updateByNot(Inform inform)throws Exception;


    //公告添加

    int insertNot(Inform inform) throws Exception;

    //公告删除

    int deleteByInform(int id)throws Exception;
    int deleteByAll(String isID)throws Exception;

    //公告查找  模糊查询
    List<Inform> selectByPage(Inform inform,int page,int limit)throws Exception;

}
