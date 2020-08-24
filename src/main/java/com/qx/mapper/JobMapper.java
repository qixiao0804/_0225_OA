package com.qx.mapper;


import com.qx.model.Job;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface JobMapper {

//    //职位查找  模糊查询
//    @Select("<script>select * from job <where> " +
//            "<if test=\"name!=null and name !=''\">name=#{name}</if>" +
//            "</where></script>")
//    List<Job> selectAll(Job job)throws Exception;

    //职位更改
    @Update("update job set name=#{name},remark=#{remark} where id = #{id}")
    int updateByJob(Job job)throws Exception;


    //职位添加
    @Insert("insert into job(name,remark) values(#{name},#{remark})")
    int insertJob(Job job) throws Exception;


    //职位删除
    @Delete("delete from job where id = #{id}")
    int deleteByJob(int id)throws Exception;

    //职位查找  模糊查询
    @Select("<script>select * from job <where> " +
            "<if test=\"name!=null and name !=''\">name=#{name}</if>" +
            "<if test=\"id!=null and id !=''\">id=#{id}</if>" +
            "<if test=\"uid!=null and uid !=''\">and uid=#{uid}</if>" +
            "</where></script>")
    List<Job> selectAll(Job job)throws Exception;







//    @Select("<script>select * from job where uid =#{id}")
//    Job selectByName(Job job)throws Exception;

}
