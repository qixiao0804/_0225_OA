package com.qx.service;

import com.qx.model.Staff;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmployeeService {

//    List<Staff> selectByAll(Staff staff)throws Exception;


    //员工添加
    int insertEmp(Staff staff) throws Exception;
//员工更改
    int updateByEmp(Staff staff)throws Exception;

    //员工删除
    int deleteByEmp(Integer id)throws Exception;
    int deleteByAll(String isID)throws Exception;


    //员工查询

    List<Staff> selectByPage(Staff staff,Integer page,Integer limit)throws Exception;

}
