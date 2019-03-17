package com.wzj.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.*;

/***
 * 统一异常处理
 * */
@ControllerAdvice
public class ExceptionAdvice {
    /**
     * 拦截捕捉自定义异常 ConstraintViolationException.class
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = ConstraintViolationException.class)
    public Map ConstraintViolationExceptionHandler(ConstraintViolationException ex) {
        Map map = new HashMap();
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
        List<String> msgList = new ArrayList<>();
        while (iterator.hasNext()) {
            ConstraintViolation<?> cvl = iterator.next();
            msgList.add(cvl.getMessageTemplate());
        }
        map.put("code", -1);
        map.put("msg", msgList);
        return map;
    }
}

