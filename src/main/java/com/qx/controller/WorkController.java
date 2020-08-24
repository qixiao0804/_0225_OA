package com.qx.controller;

import com.github.pagehelper.PageInfo;
import com.qx.model.Work;
import com.qx.model.base.Result;
import com.qx.service.WordService;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/word")
public class WorkController {

    private static Logger logger = Logger.getLogger(WorkController.class);
    @Autowired
    private WordService workService;

    @RequestMapping("/findByWord.do")
    public Result findByWork(Work work,int page,int limit)throws Exception{
        List<Work> works = workService.selectPage(work,page,limit);
        Result result = new Result();
        if(works!=null){
            result.setCode(Result.code_success);
            result.setMsg(Result.msg_success);
            result.setData(works);
            long total = PageInfo.of(works).getTotal();
            result.setCount((int)total);
            logger.info("查询文档成功");
            return result;
        }else {
            result.setCode(Result.code_failed);
            result.setMsg(Result.msg_failed);
            logger.info("查询文档失败");
            return result;
        }
    }
    @RequestMapping("/updateByWord.do")
    public Result updateByWord(Work work, @RequestParam("file")MultipartFile file)throws Exception{

        work.setFileName(file.getOriginalFilename());
        int i = workService.updateByWork(work);
        Result result = new Result();
        if(i>0){
            file.transferTo(new File("E:\\ideaQx\\_0225_OA\\src\\main\\webapp\\upload",file.getOriginalFilename()));

            result.setCode(Result.code_success);
            result.setMsg(Result.msg_success);
            logger.info("更改文档成功");
            return result;
        }else {
            result.setCode(Result.code_failed);
            result.setMsg(Result.msg_failed);
            logger.info("更改文档失败");
            return result;
        }

    }


    @RequestMapping("/wordDown.do")
    public ResponseEntity<byte[]> download(String filename) throws  Exception{

        System.out.println(filename);
        String path = "E:\\ideaQx\\_0225_OA\\src\\main\\webapp\\upload";
        String downloadpath = path + "\\"+filename;
        File file = new File(downloadpath);

        if(file.exists()){
            byte[] bytes = FileUtils.readFileToByteArray(file);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Content-Disposition","attachment;filename="+filename);
            HttpStatus ok = HttpStatus.OK;
            logger.info("文档下载成功");
            return new ResponseEntity<>(bytes,httpHeaders,ok);

        }else {
            logger.info("文档下载失败");
            return null;
        }
    }

    @RequestMapping("/addByWord.do")
    public Result addByWord(Work work,@RequestParam("file")MultipartFile file)throws Exception{
        work.setCreateDate(new Date());
        work.setFileName(file.getOriginalFilename());
        int i = workService.insertByWord(work);

        Result result = new Result();
        if(i>0){
            file.transferTo(new File("E:\\ideaQx\\_0225_OA\\src\\main\\webapp\\upload",file.getOriginalFilename()));

            result.setCode(Result.code_success);
            result.setMsg(Result.msg_success);
            logger.info("添加文档成功");
            return result;
        }else {
            result.setCode(Result.code_failed);
            result.setMsg(Result.msg_failed);
            logger.info("添加文档失败");
            return result;
        }
    }



    @RequestMapping("/removeByAll.do")
    public Result removeByAll(String sID)throws Exception{
        int i = workService.deleteByAll(sID);
        Result result = new Result();
        if(i>0){
            result.setCode(Result.code_success);
            result.setMsg(Result.msg_success);
            logger.info("删除文档成功");
            return result;
        }else {
            result.setCode(Result.code_failed);
            result.setMsg(Result.msg_failed);
            logger.info("删除文档失败");
            return result;
        }
    }




}
