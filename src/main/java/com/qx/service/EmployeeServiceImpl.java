package com.qx.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qx.mapper.EmployeeMapper;
import com.qx.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

//    @Override
//    public List<Staff> selectByAll(Staff staff) throws Exception {
//        return employeeMapper.selectByAll(staff);
//    }

    @Override
    @Transactional
    public int insertEmp(Staff staff) throws Exception {
        return employeeMapper.insertEmp(staff);
    }

    @Override
    @Transactional
    public int updateByEmp(Staff staff) throws Exception {
        return employeeMapper.updateByEmp(staff);
    }

    @Override
    @Transactional
    public int deleteByEmp(Integer id) throws Exception {
        return employeeMapper.deleteByEmp(id);
    }

    @Override
    public List<Staff> selectByPage(Staff staff, Integer page, Integer limit) throws Exception {
        System.out.println(page);
        PageHelper.startPage(page, limit);
        System.out.println(employeeMapper);
        return employeeMapper.selectByAll(staff);
    }


    @Override
    @Transactional
    public int deleteByAll(String isID) throws Exception {
        if(isID!=null&& !isID.equals("")){
            String [] ids = isID.split(",");
            for (String sid:ids) {
                if(sid!=null && !sid.equals("")){
                    int id = Integer.parseInt(sid);
                    int i = employeeMapper.deleteByEmp(id);
                    return i;
                }
                return 0;
            }
        }
        return 0;
    }
    }

