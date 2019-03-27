package com.wzj.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 统一异常处理
 * */
@RestControllerAdvice
public class ExceptionAdvice {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 拦截捕捉自定义异常Exception.class
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Map ExceptionHandler(Exception e) {
        Map map = new HashMap();
        Map<String,Object> dataMap=new HashMap<>();
        List<Object> dataList=new ArrayList();
        StackTraceElement[] stackTraceElements=e.getStackTrace();
        System.out.println(stackTraceElements[0].getClass());
        System.out.println(stackTraceElements[0].getClassName());
        System.out.println(stackTraceElements[0].getMethodName());
        System.out.println(stackTraceElements[0].getClassName());
        System.out.println(stackTraceElements[0].getFileName());
        for(int i=0;i<stackTraceElements.length;i++){
            if(stackTraceElements[i].getClassName().contains("Controller")){
                dataList.add(stackTraceElements[i]);
            }
        }
        dataMap.put("result",e.getMessage());
        dataMap.put("helpInfo",dataList);
        map.put("code", -1);
        map.put("msg","失败");
        map.put("data",dataMap);
        return map;
    }


//    @ResponseBody
//    @ExceptionHandler(value = ArithmeticException.class)
//    public Map ArithmeticExceptionHandler(ArithmeticException ex) {
//        Map map = new HashMap();
//        map.put("code", -1);
//        map.put("msg", ex.getMessage());
//        map.put("msg2", ex.getLocalizedMessage());
//        map.put("msg3", ex.getCause());
//        map.put("msg4", ex.getCause());
//        map.put("msg5", ex.getSuppressed());
//        map.put("msg6", ex.getClass());
//        return map;
//    }
}

