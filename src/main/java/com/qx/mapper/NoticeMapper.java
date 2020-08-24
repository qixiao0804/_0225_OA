package com.qx.mapper;

import com.qx.model.Department;
import com.qx.model.Inform;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface NoticeMapper {


//    //公告查找  模糊查询
//    @Select("<script>select * from inform <where> " +
//            "<if test=\"title!=null and title !=''\">title=#{title}</if>" +
//            "<if test=\"content!=null and content !=''\">content=#{content}</if>" +
//            "</where></script>")
//    List<Inform> selectAll(Inform inform)throws Exception;


    //公告更改
    @Update("update inform set title=#{title},content=#{content} where id =#{id}")
    int updateByNot(Inform inform)throws Exception;


    //公告添加
    @Insert("insert into inform(title,content,createDate) values(#{title},#{content},#{createDate})")
    int insertNot(Inform inform) throws Exception;


    //公告删除
    @Delete("delete from inform where id = #{id}")
    int deleteByInform(int id)throws Exception;


    //公告查找  模糊查询
    @Select("<script>select * from inform <where> " +
            "<if test=\"title!=null and title !=''\">title=#{title}</if>" +
            "<if test=\"content!=null and content !=''\">and content=#{content}</if>" +
            "</where></script>")
    List<Inform> selectAll(Inform inform)throws Exception;
}
