package com.qx.controller;

import com.github.pagehelper.PageInfo;
import com.qx.model.Email;
import com.qx.model.base.Result;
import com.qx.service.EmailService;
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

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/email")
public class EmailController {
    private static Logger logger = Logger.getLogger(EmailController.class);
    @Autowired
    private EmailService emailService;
    @RequestMapping("/findByEmail.do")
    public Result findByEmail(int page,int limit)throws Exception{
        List<Email> emails = emailService.selectByPage(page,limit);
        Result result = new Result();
        if(emails!=null){
            result.setCode(Result.code_success);
            result.setMsg(Result.msg_success);
            result.setData(emails);
            long total = PageInfo.of(emailService.selectByPage(page, limit)).getTotal();
            result.setCount((int)total);
            logger.info("查询邮件成功");
            return result;
        }else {
            result.setCode(Result.code_failed);
            result.setMsg(Result.msg_failed);
            logger.info("查询邮件失败");
            return result;
        }
    }

    @RequestMapping("/addByEmail.do")
    public Result addByEmail(Email email , @RequestParam("file") MultipartFile multipartFile)throws Exception{


        email.setCreateDate(new Date());
        email.setAttachment(multipartFile.getOriginalFilename());
        int i = emailService.insertByEmail(email);
        Result result = new Result();
        if(i>0){
            multipartFile.transferTo(new File("E:\\ideaQx\\_0225_OA\\src\\main\\webapp\\upload",multipartFile.getOriginalFilename()));
            result.setCode(Result.code_success);
            result.setMsg(Result.msg_success);
            logger.info("邮件发送成功");
            return result;
        }else {
            result.setCode(Result.code_failed);
            result.setMsg(Result.msg_failed);
            logger.info("邮件发送失败");
            return result;
        }
    }

    @RequestMapping("/removeByEmail.do")
    public Result removeByEmail(int id)throws Exception{
        int i = emailService.deleteByEmail(id);
        Result result = new Result();
        if(i>0){
            result.setCode(Result.code_success);
            result.setMsg(Result.msg_success);
            logger.info("邮件删除成功");
            return result;
        }else {
            result.setCode(Result.code_failed);
            result.setMsg(Result.msg_failed);
            logger.info("邮件删除失败");
            return result;
        }
    }


    @RequestMapping("/emailDown.do")
    public ResponseEntity<byte[]> download(String filename) throws  Exception{

        String path = "E:\\ideaQx\\_0225_OA\\src\\main\\webapp\\upload";
        String downloadpath = path + "\\"+filename;
        File file = new File(downloadpath);

        if(file.exists()){
            byte[] bytes = FileUtils.readFileToByteArray(file);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Content-Disposition","attachment;filename="+filename);
            HttpStatus ok = HttpStatus.OK;
            logger.info("邮件下载成功");
            return new ResponseEntity<>(bytes,httpHeaders,ok);

        }else {
            logger.info("邮件下载失败");
            return null;
        }
    }
}
