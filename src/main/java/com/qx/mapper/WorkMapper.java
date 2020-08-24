package com.qx.mapper;

import com.qx.model.Department;
import com.qx.model.Work;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface WorkMapper {

//    //文档查找  模糊查询
//    @Select("<script>select work.*,user.username as uname from work left join user on work.uid=user.id <where> " +
//            "<if test=\"title!=null and title !=''\">title=#{title}</if>" +
//            "</where></script>")
//    List<Work> selectAll(Work work)throws Exception;

    //文档更改
    @Update("update work set title=#{title},fileName=#{fileName},remark= #{remark} where id =#{id}")
    int updateByWork(Work work)throws Exception;

    //文档添加
    @Insert("insert into work (title,fileName,remark,uid,createDate) values(#{title},#{fileName},#{remark},#{uid},#{createDate})")
    int insertByWord(Work work) throws  Exception;

    //文档查找  模糊查询
    @Select("<script>select work.*,user.username as uname from work left join user on work.uid=user.id <where> " +
            "<if test=\"title!=null and title !=''\">title=#{title}</if>" +
            "</where></script>")
    List<Work> selectAll(Work work)throws Exception;


    //删除文档
    @Delete("delete from work where uid = #{id}")
    int deleteByWord(Integer uid);

    //删除文档
    @Delete("delete from work where id = #{id}")
    int deleteByid(Integer id);

}
