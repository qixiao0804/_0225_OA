package com.qx.mapper;

import com.qx.model.Department;
import com.qx.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DepartmentMapper {

    //部门查找  模糊查询
//    @Select("<script>select * from department <where> " +
//            "<if test=\"name!=null and name !=''\">name=#{name}</if>" +
//            "</where></script>")
//    List<Department> selectAll(Department department)throws Exception;

    //部门更改
    @Update("update department set name=#{name},remark=#{remark} where id =#{id}")
    int updateByDep(Department department)throws Exception;


    //部门添加
    @Insert("insert into department(name,remark) values(#{name},#{remark})")
    int insertDep(Department department) throws Exception;

    //部门删除
    @Delete("delete from department where id = #{id}")
    int deleteByDep(int id)throws Exception;


    //部门查找page  模糊查询
    @Select("<script>select * from department <where> " +
            "<if test=\"name!=null and name !=''\">name=#{name}</if>" +
            "</where></script>")
    List<Department> selectPage(Department department)throws Exception;

}
