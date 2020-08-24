package com.qx.controller;

import com.github.pagehelper.PageInfo;
import com.qx.model.Department;
import com.qx.model.base.Result;
import com.qx.service.DepartmentService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/depart")
public class DepartmentController {

    private static Logger logger = Logger.getLogger(DepartmentController.class);
    @Autowired
   DepartmentService departmentService;

    @RequestMapping("/findDep.do")
    public Result findDep(Department department,int page,int limit)throws Exception{
        List<Department> departments = departmentService.selectAll(department, page, limit);
        Result result = new Result();
        if(!departments.isEmpty()){
            result.setCode(Result.code_success);
            result.setMsg(Result.msg_success);
            result.setData(departments);
            long total = PageInfo.of(departmentService.selectAll(department, page, limit)).getTotal();
            result.setCount((int)total);
            logger.info("查询部门成功");
            return result;
        }else {
            result.setCode(Result.code_failed);
            result.setMsg(Result.msg_failed);
            logger.info("查询部门失败");
            return result;
        }

    }

    @RequestMapping("/updateByDep.do")
    public Result updateByDep(Department department)throws Exception{
        int i = departmentService.updateByDep(department);
        Result result = new Result();
        if(i>0){
            result.setCode(Result.code_success);
            result.setMsg(Result.msg_success);
            logger.info("更改部门成功");
            return result;
        }else {
            result.setCode(Result.code_failed);
            result.setMsg(Result.msg_failed);
            logger.info("更改部门失败");
            return result;
        }
    }



    @RequestMapping("/addByDep.do")
    public Result addByDep(Department department)throws Exception{
        int i = departmentService.insertDep(department);
        Result result = new Result();
        if(i>0){
            result.setCode(Result.code_success);
            result.setMsg(Result.msg_success);
            logger.info("添加部门成功");
            return result;
        }else {
            result.setCode(Result.code_failed);
            result.setMsg(Result.msg_failed);
            logger.info("添加部门失败");
            return result;
        }
    }

    @RequestMapping("/removeByDep.do")
    public Result removeByDep(Integer id)throws Exception{
        System.out.println(id);
        int i = departmentService.deleteByDep(id);
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



    @RequestMapping("/removeByAll.do")
    public Result removeByAll(String sID)throws Exception{
        int i = departmentService.deleteByAll(sID);
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
