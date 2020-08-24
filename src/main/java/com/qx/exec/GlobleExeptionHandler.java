package com.qx.exec;


import com.qx.model.base.Result;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobleExeptionHandler {

    private static Logger logger = Logger.getLogger(GlobleExeptionHandler.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result doException(Exception ex){
        Result result = new Result();
        result.setCode(Result.code_failed);
        result.setMsg(Result.msg_failed);
        if(ex instanceof BizException){
            logger.info("业务异常，无需处理",ex);
        }else {
            logger.error("系统Bug",ex);
        }
        return result;
    }
}
