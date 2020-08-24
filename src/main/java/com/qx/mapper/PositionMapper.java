package com.qx.mapper;


import com.qx.model.Position;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface PositionMapper {


    //职位查找  模糊查询
    @Select("<script>select * from job <where> " +
            "<if test=\"id!=null and id !=''\">id=#{id}</if>" +
            "</where></script>")
    Position selectPdf(@Param("id") int id)throws Exception;

}
