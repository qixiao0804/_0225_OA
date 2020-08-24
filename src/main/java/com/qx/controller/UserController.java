package com.qx.controller;

import com.github.pagehelper.PageInfo;
import com.qx.model.User;
import com.qx.model.base.Result;
import com.qx.service.UserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private static Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    UserService service;
    public UserController(){
        System.out.println("UserController()");
    }
    //登录
    @RequestMapping(value = "/login.do")
    public Result login(User user, HttpSession session, Boolean RemFlag, HttpServletResponse httpServletResponse)throws Exception{
        User userLogin = service.findByLogin(user.getLoginname(), user.getPassword());


        if(RemFlag){
            String username = user.getLoginname();
            Cookie userCookie=new Cookie("username",username);
            userCookie.setMaxAge(24*3600);
            httpServletResponse.addCookie(userCookie);
        }


        Result result = new Result();
        if(userLogin!=null){

            result.setCode(Result.code_success);
            result.setMsg(Result.msg_success);
            session.setAttribute("user",userLogin);
            logger.info("登录成功");
            return result;
        }else {
            result.setCode(Result.code_failed);
            result.setMsg(Result.msg_failed);
            logger.info("登录失败");
            return result;
        }
    }



    @RequestMapping("/cookie.do")
    public Result cookie( HttpServletRequest httpServletRequest){
        Cookie[] cookies = httpServletRequest.getCookies();
        String value = cookies[0].getValue();
        Result result = new Result();
        if(value.length()>=10){
            result.setCode(Result.code_failed);
            result.setMsg(Result.msg_failed);

        }else {
            result.setCode(Result.code_success);
            result.setMsg(Result.msg_success);
            result.setData(value);
        }
            return result;

    }




    @RequestMapping("/session.do")
    public Result session(HttpSession session, HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){


        User user = (User) session.getAttribute("user");
        Result result = new Result();
        result.setData(user);
        return result;
    }



    @RequestMapping("/removeSession.do")
    public String removeSession(HttpSession session){
            session.invalidate();
        return "/html/loginForm.html";
    }

//    @RequestMapping("/userPage.do")
//    public Result userPage(User)throws Exception{
//        List<User> all = service.findAll();
//        Result result = new Result();
//        result.setMsg(Result.msg_success);
//        result.setCode(Result.code_success);
//        result.setData(all);
//        return result;
//    }

    @RequestMapping("/userLike.do")
    public Result userLike(User user,int page,int limit)throws Exception{
        List<User> users = service.selectByLike(user,page,limit);
        Result result = new Result();
        if (users.isEmpty()){
            result.setCode(Result.code_failed);
        }else {
            result.setMsg(Result.msg_success);
            result.setCode(Result.code_success);
            long total = PageInfo.of(users).getTotal();
            result.setCount((int) total);
            result.setData(users);
        }
        return result;
    }

    @RequestMapping("/updateUser.do")
    public Result updateUser(User user)throws Exception{
        int i = service.updateByUser(user);
        Result result = new Result();
        result.setMsg(Result.msg_success);
        result.setCode(Result.code_success);
        return result;
    }


    //添加用户
    @RequestMapping("/addUser.do")
    public Result addUser(User user)throws Exception{
        user.setCreateDate(new Date());
        int i = service.addUser(user);
        Result result = new Result();
        if(i>0){
            result.setMsg(Result.msg_success);
            result.setCode(Result.code_success);
            logger.info("添加成功");
            return result;
        }
        else {
            result.setCode(Result.code_failed);
            result.setMsg(Result.msg_failed);
            logger.info("添加失败");
            return result;
        }

    }



    @RequestMapping("/removeByUser.do")
    public Result removeByUser(int id)throws Exception{

        int i = service.deleteByUser(id);
        Result result = new Result();
        if(i>0){
            result.setCode(Result.code_success);
            result.setMsg(Result.msg_success);
            logger.info("删除用户成功");
            return result;
        }else {
            result.setCode(Result.code_failed);
            result.setMsg(Result.msg_failed);
            logger.info("删除用户失败");
            return result;
        }
    }




    @RequestMapping("/removeByAll.do")
    public Result removeByAll(String sID)throws Exception{
        int i = service.deleteByAll(sID);
        Result result = new Result();
        if(i>0){
            result.setCode(Result.code_success);
            result.setMsg(Result.msg_success);
            logger.info("删除用户成功");
            return result;
        }else {
            result.setCode(Result.code_failed);
            result.setMsg(Result.msg_failed);
            logger.info("删除用户失败");
            return result;
        }
    }


    @RequestMapping("/userByName.do")
    public Result userByName(User user)throws Exception{
        User users = service.selectByName(user);
        Result result = new Result();
        result.setMsg(Result.msg_success);
        result.setCode(Result.code_success);
        result.setData(users);
        return result;
    }




}
