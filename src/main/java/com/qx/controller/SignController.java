package com.qx.controller;

import com.github.pagehelper.PageInfo;
import com.qx.model.Poi;
import com.qx.model.Sign;
import com.qx.model.base.Result;
import com.qx.service.SignService;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/sign")
public class SignController {
    private static Logger logger = Logger.getLogger(SignController.class);

    @Autowired
    private SignService signService;

    @RequestMapping("/findBySignAll.do")
    public Result findBySignAll(Sign sign,int page,int limit)throws Exception{
        List<Sign> signs = signService.selectBypage(sign,page,limit);


        Result result = new Result();
        if(signs!=null){
            result.setCode(Result.code_success);
            result.setMsg(Result.msg_success);
            result.setData(signs);
            long total = PageInfo.of(signService.selectBypage(sign, page, limit)).getTotal();
            System.out.println(page);
            System.out.println(limit);
            System.out.println(total);
            result.setCount((int)total);
            logger.info("查询签到成功");
            return result;
        }else {
            result.setCode(Result.code_failed);
            result.setMsg(Result.msg_failed);
            logger.info("查询签到失败");
            return result;
        }
    }


    @RequestMapping("/findBySignName.do")
    public Map<String,Object> findBySignName(Sign sign,int page,int limit)throws Exception{
        List<Sign> signs = signService.selectBypage1(sign,page,limit);

        System.out.println(sign.getCreatetime());
        List<Integer> stime = new ArrayList<>();
        List<Integer> dtime = new ArrayList<>();
        List<String> date1 = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy/MM/dd HH");
        for(int i =0;i<signs.size();i++){
            Date createtime = signs.get(i).getCreatetime();
            String format = simpleDateFormat.format(createtime);
            if( Integer.parseInt(format.split(" ")[1])<=12){
                stime.add(Integer.parseInt(format.split(" ")[1]));
            }else {
                dtime.add(Integer.parseInt(format.split(" ")[1]));
            }
            date1.add(format.split("/")[1]+"月"+format.split(" ")[0].split("/")[2]+"日");
        }

        Set set = new LinkedHashSet();
        List date = new  ArrayList();
        set.addAll(date1);
        date.addAll(set);


        Map<String,Object> map = new HashMap<>();
        map.put("stime",stime);
        map.put("dtime",dtime);
        map.put("date",date);

        return map;


//        Result result = new Result();
//        if(signs!=null){
//            result.setCode(Result.code_success);
//            result.setMsg(Result.msg_success);
//            result.setData(signs);
//            logger.info("查询成功");
//            return result;
//        }else {
//            result.setCode(Result.code_failed);
//            result.setMsg(Result.msg_failed);
//            logger.info("查询失败");
//            return result;
//        }
    }


    @RequestMapping("/addBySign.do")
    public Result addBySign(Sign sign)throws Exception{
        sign.setCreatetime(new Date());
        int i = signService.insertBySign(sign);
        Result result = new Result();
        if(i>0){
            result.setCode(Result.code_success);
            result.setMsg(Result.msg_success);
            logger.info("打卡成功");
            return result;
        }else {
            result.setCode(Result.code_failed);
            result.setMsg(Result.msg_failed);
            logger.info("打卡失败");
            return result;
        }

    }























}
