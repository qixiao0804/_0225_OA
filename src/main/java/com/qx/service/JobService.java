package com.qx.service;

import com.qx.model.Department;
import com.qx.model.Job;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface JobService {


    //职位查找  模糊查询

//    List<Job> selectAll(Job job)throws Exception;

    //职位更改

    int updateByJob(Job job)throws Exception;

    //职位添加

    int insertJob(Job job) throws Exception;

    //职位删除

    int deleteByJob(int id)throws Exception;
    int deleteByAll(String isID)throws Exception;

    //职位分页  模糊查询
    List<Job> selectPage(Job job,int page,int limit)throws Exception;


}
