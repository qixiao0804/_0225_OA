package com.qx.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qx.mapper.DepartmentMapper;
import com.qx.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

//    @Override
//    public List<Department> selectAll(Department department) throws Exception {
//
//        return departmentMapper.selectAll(department);
//    }

    @Override
    @Transactional
    public int updateByDep(Department department) throws Exception {
        return departmentMapper.updateByDep(department);
    }

    @Override
    @Transactional
    public int insertDep(Department department) throws Exception {
        return departmentMapper.insertDep(department);
    }

    @Override
    @Transactional
    public int deleteByDep(int id) throws Exception {
        return departmentMapper.deleteByDep(id);
    }

    @Override
    public List<Department> selectAll(Department department,int page,int limit) throws Exception {
        PageHelper.startPage(page,limit);
        List<Department> departments = departmentMapper.selectPage(department);
        return departments;
    }


    @Override
    @Transactional
    public int deleteByAll(String isID) throws Exception {


        if(isID!=null&& !isID.equals("")){
            String [] ids = isID.split(",");
            for (String sid:ids) {
                if(sid!=null && !sid.equals("")){
                    int id = Integer.parseInt(sid);
                    int i = departmentMapper.deleteByDep(id);
                    return i;
                }
                return 0;
            }
        }
        return 0;
    }



}
