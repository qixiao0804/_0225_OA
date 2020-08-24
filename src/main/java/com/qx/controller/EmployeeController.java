package com.qx.controller;

import com.github.pagehelper.PageInfo;
import com.qx.model.Department;
import com.qx.model.Staff;
import com.qx.model.base.Result;
import com.qx.service.EmployeeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/em")
public class EmployeeController {

    private static Logger logger = Logger.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping("/findByAll.do")
    public Result findByAll(Staff staff,Integer page,Integer limit)throws Exception{

        List<Staff> staff1 = employeeService.selectByPage(staff,page,limit);
        Result result = new Result();
        if(staff1!=null){
            result.setCode(Result.code_success);
            result.setMsg(Result.msg_success);
            result.setData(staff1);
            long total = PageInfo.of(staff1).getTotal();

            result.setCount((int)total);
            logger.info("查询员工成功");
            return result;
        }else {
            result.setCode(Result.code_failed);
            result.setMsg(Result.msg_failed);
            logger.info("查询员工失败");
            return result;
        }
    }

    @RequestMapping("/addEmp.do")
    public Result addEmp(Staff staff)throws Exception{
        staff.setCreateDate(new Date());
        int i = employeeService.insertEmp(staff);
        Result result = new Result();
        if(i>0){
            result.setCode(Result.code_success);
            result.setMsg(Result.msg_success);
            logger.info("添加员工成功");
            return result;
        }else {
            result.setCode(Result.code_failed);
            result.setMsg(Result.msg_failed);
            logger.info("添加员工失败");
            return result;
        }
    }


    @RequestMapping("/updateByEmp.do")
    public Result updateByEmp(Staff staff)throws Exception{
        int i =employeeService.updateByEmp(staff);
        Result result = new Result();
        if(i>0){
            result.setCode(Result.code_success);
            result.setMsg(Result.msg_success);
            logger.info("更改员工成功");
            return result;
        }else {
            result.setCode(Result.code_failed);
            result.setMsg(Result.msg_failed);
            logger.info("更改员工失败");
            return result;
        }
    }




    @RequestMapping("/removeByEmp.do")
    public Result removeByEmp(Integer id)throws Exception{
        int i = employeeService.deleteByEmp(id);
        Result result = new Result();
        if(i>0){
            result.setCode(Result.code_success);
            result.setMsg(Result.msg_success);
            logger.info("删除员工成功");
            return result;
        }else {
            result.setCode(Result.code_failed);
            result.setMsg(Result.msg_failed);
            logger.info("删除员工失败");
            return result;
        }
    }




    @RequestMapping("/removeByAll.do")
    public Result removeByAll(String sID)throws Exception{
        int i = employeeService.deleteByAll(sID);
        Result result = new Result();
        if(i>0){
            result.setCode(Result.code_success);
            result.setMsg(Result.msg_success);
            logger.info("删除部门成功");
            return result;
        }else {
            result.setCode(Result.code_failed);
            result.setMsg(Result.msg_failed);
            logger.info("删除部门失败");
            return result;
        }
    }



}
