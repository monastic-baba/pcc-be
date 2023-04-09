package com.keep.pcc.exception.handler;

import com.keep.pcc.exception.NotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.Annotation;

//@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(NotFoundException.class)
    public ResponseBody handleNotFoundException(){
       System.out.println("in global exception handler");
       return new ResponseBody(){
           @Override
           public Class<? extends Annotation> annotationType() {
               return null;
           }
       };
    }
}
