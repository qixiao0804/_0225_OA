package com.qx.controller;

import com.github.pagehelper.PageInfo;
import com.qx.model.Inform;
import com.qx.model.base.Result;
import com.qx.service.NoticeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/not")
public class NoticeController {

    private static Logger logger = Logger.getLogger(NoticeController.class);
    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/findByNotAll.do")
    public Result findAll(Inform inform,int page,int limit)throws Exception{
        List<Inform> informs = noticeService.selectByPage(inform,page,limit);
        Result result = new Result();
        if(informs!=null){
            result.setCode(Result.code_success);
            result.setMsg(Result.msg_success);
            result.setData(informs);
            long total = PageInfo.of(informs).getTotal();
            result.setCount((int)total);
            logger.info("查询公告成功");
            return result;
        }else {
            result.setCode(Result.code_failed);
            result.setMsg(Result.msg_failed);
            logger.info("查询公告失败");
            return result;
        }
    }
    @RequestMapping("/updateByNot.do")
    public Result updateByNot(Inform inform)throws Exception{
        int i = noticeService.updateByNot(inform);
        Result result = new Result();
        if(i>0){
            result.setCode(Result.code_success);
            result.setMsg(Result.msg_success);
            logger.info("更改公告成功");
            return result;
        }else {
            result.setCode(Result.code_failed);
            result.setMsg(Result.msg_failed);
            logger.info("更改公告失败");
            return result;
        }
    }
    @RequestMapping("/addByNot.do")
    public Result addByNot(Inform inform)throws Exception{
        inform.setCreateDate(new Date());
        int i = noticeService.insertNot(inform);
        Result result = new Result();
        if(i>0){
            result.setCode(Result.code_success);
            result.setMsg(Result.msg_success);
            logger.info("添加公告成功");
            return result;
        }else {
            result.setCode(Result.code_failed);
            result.setMsg(Result.msg_failed);
            logger.info("添加公告失败");
            return result;
        }
    }


    @RequestMapping("/removeByInform.do")
    public Result removeByEmp(Integer id)throws Exception{
        int i = noticeService.deleteByInform(id);
        Result result = new Result();
        if(i>0){
            result.setCode(Result.code_success);
            result.setMsg(Result.msg_success);
            logger.info("删除公告成功");
            return result;
        }else {
            result.setCode(Result.code_failed);
            result.setMsg(Result.msg_failed);
            logger.info("删除公告失败");
            return result;
        }
    }

    @RequestMapping("/removeByAll.do")
    public Result removeByAll(String sID)throws Exception{
        int i = noticeService.deleteByAll(sID);
        Result result = new Result();
        if(i>0){
            result.setCode(Result.code_success);
            result.setMsg(Result.msg_success);
            logger.info("删除公告成功");
            return result;
        }else {
            result.setCode(Result.code_failed);
            result.setMsg(Result.msg_failed);
            logger.info("删除公告失败");
            return result;
        }
    }

}
