package com.qx.service;

import com.qx.model.Department;
import com.qx.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DepartmentService {


    //部门查找  模糊查询

//    List<Department> selectAll(Department department)throws Exception;

    //部门更改

    int updateByDep(Department department)throws Exception;

    //部门添加

    int insertDep(Department department) throws Exception;

    //部门删除
    int deleteByDep(int id)throws Exception;
    int deleteByAll(String isID)throws Exception;
    //部门查找page  模糊查询

    List<Department> selectAll(Department department,int page,int limit)throws Exception;

}
