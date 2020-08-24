package com.qx.controller;

import com.github.pagehelper.PageInfo;
import com.qx.model.Department;
import com.qx.model.Job;
import com.qx.model.base.Result;
import com.qx.service.JobService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {

    private static Logger logger = Logger.getLogger(JobController.class);
    @Autowired
    private JobService jobService;


    @RequestMapping("/findJob.do")
    public Result findJob(Job job,int page,int limit)throws Exception{
        System.out.println(job.getUid());
        List<Job> jobs = jobService.selectPage(job,page,limit);
        Result result = new Result();
        if(jobs!=null){
            result.setCode(Result.code_success);
            result.setMsg(Result.msg_success);
            long total = PageInfo.of(jobs).getTotal();
            result.setCount((int)total);
            result.setData(jobs);
            logger.info("查询职位成功");
            return result;
        }else {
            result.setCode(Result.code_failed);
            result.setMsg(Result.msg_failed);
            logger.info("查询职位失败");
            return result;
        }

    }

    @RequestMapping("/updateByJob.do")
    public Result updateByJob(Job job)throws Exception{
        int i = jobService.updateByJob(job);
        Result result = new Result();
        if(i>0){
            result.setCode(Result.code_success);
            result.setMsg(Result.msg_success);
            logger.info("更改职位成功");
            return result;
        }else {
            result.setCode(Result.code_failed);
            result.setMsg(Result.msg_failed);
            logger.info("更改职位失败");
            return result;
        }
    }



    @RequestMapping("/addByJob.do")
    public Result addByJob(Job job)throws Exception{
        int i = jobService.insertJob(job);
        Result result = new Result();
        if(i>0){
            result.setCode(Result.code_success);
            result.setMsg(Result.msg_success);
            logger.info("添加职位成功");
            return result;
        }else {
            result.setCode(Result.code_failed);
            result.setMsg(Result.msg_failed);
            logger.info("添加职位失败");
            return result;
        }
    }


    @RequestMapping("/removeByJob.do")
    public Result removeByJob(Integer id)throws Exception{
        int i = jobService.deleteByJob(id);
        Result result = new Result();
        if(i>0){
            result.setCode(Result.code_success);
            result.setMsg(Result.msg_success);
            logger.info("删除职位成功");
            return result;
        }else {
            result.setCode(Result.code_failed);
            result.setMsg(Result.msg_failed);
            logger.info("删除职位失败");
            return result;
        }
    }

    @RequestMapping("/removeByAll.do")
    public Result removeByAll(String sID)throws Exception{
        int i = jobService.deleteByAll(sID);
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
