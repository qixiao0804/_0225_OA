package com.qx.service;


import com.qx.model.Work;


import java.util.List;

public interface WordService {

    //文档查找  模糊查询

//    List<Work> selectAll(Work work)throws Exception;

    //文档更改
    int updateByWork(Work work)throws Exception;

    //文档添加

    int insertByWord(Work work) throws  Exception;

    //文档查找  模糊查询

    List<Work> selectPage(Work work,int page,int limit)throws Exception;

    int deleteByAll(String isID)throws Exception;
}
