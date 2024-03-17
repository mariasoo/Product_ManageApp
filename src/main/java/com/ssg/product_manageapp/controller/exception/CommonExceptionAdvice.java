package com.ssg.product_manageapp.controller.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Arrays;

@ControllerAdvice
@Log4j2
public class CommonExceptionAdvice { //범용적인 예외처리

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String exceptionCommon(Exception exception){
        log.info("==================================");
        log.error(exception.getMessage());
        StringBuffer buffer = new StringBuffer("<ul>");
        buffer.append("<li>"+exception.getMessage()+"<li>");
        Arrays.stream(exception.getStackTrace()).forEach(stackTraceElement -> {
            buffer.append("<li>"+stackTraceElement+"</li>");
        });
        buffer.append("</ul>");
//        return "Number Format Exception";
        return buffer.toString();
        // 내가 만든 문자열을 바디에 전달 ResponseBody
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound(){
        return "custom404";
    }
    
}


