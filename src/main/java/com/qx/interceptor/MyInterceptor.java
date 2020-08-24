package com.qx.interceptor;

import com.qx.model.User;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyInterceptor implements HandlerInterceptor {

    /**
     * 请求到达控制器之前要执行的业务代码
     * 返回值为false,则执行请求的拦截.
     * 返回值为true,则表示不拦截请求,会向下调用后续的拦截器及控制器
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println(request.getRequestURI());

        if(request.getRequestURI().contains("loginForm.html")){

            return true;
        }

        if(request.getRequestURI().contains("cookie.do")){

            return true;
        }

        if(request.getRequestURI().contains("login.do")){

            return true;
        }
        HttpSession session = request.getSession();

        if(session.getAttribute("user")!=null){

            return true;
        }

//        request.getRequestDispatcher("/html/loginForm.html").forward(request,response);
        response.sendRedirect("/html/loginForm.html");

        return false;
    }

    /**
     * 表示控制器执行完后,将要执行的业务代码
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("postHandle");
    }

    /**
     * 表示控制器执行完后,作出响应,将要执行的代码,在postHandle之后执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("afterCompletion");

    }
}
