package com.qx.mapper;

import com.qx.model.Sign;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SignMapper {

    //签到表查询
//    @Select("<script> select * from sign <where> <if test=\'createtime !=null and createtime !=''\'> createtime &gt;=#{createtime} and createtime &lt;=#{createtime} </if></where> </script>")

//    @Select("<script>select * from sign <where> " +
//            "<if test=\"createtime!=null \">createtime &gt;=#{createtime} and createtime &lt;=#{createtime2} </if>" +
//            "</where></script>")
//    List<Sign> selectBySign(Sign sign)throws Exception;

    @Select("select * from sign where uid =#{uid} <if test=\"createtime!=null \">and createtime &gt;=#{createtime} </if>")
    Sign selectByName(Sign sign)throws Exception;


    //打卡
    @Insert("insert into sign(createtime,flag,uid) values(#{createtime},#{flag},#{id})")
    int insertBySign(Sign sign)throws Exception;


    @Select("<script>select * from sign <where> " +
            "<if test=\"createtime!=null \">createtime &gt;=#{createtime} and createtime &lt;=#{createtime2} </if>" +
            "</where></script>")
   List<Sign> selectBypage(Sign sign)throws Exception;



    @Select("<script>select * from sign <where> " +
            "<if test=\"createtime!=null \">createtime >#{createtime} </if>" +
            "</where></script>")


//    @Select("select * from sign where  createtime >#{createtime} ")

    List<Sign> selectBypage1(Sign sign)throws Exception;

    //删除文档
    @Delete("delete from sign where uid = #{id}")
    int deleteBySign(Integer id);
}
