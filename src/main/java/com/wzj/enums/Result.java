package com.wzj.enums;

import java.util.HashMap;
import java.util.Map;

public enum Result {
    /**
     * 成功码0失败码1
     * */
    SUCCESS_CODE,FAIL_CODE;
    /**
     * 返回成功
     * */
    public static Map<String,Object> retrunSucess(){
        Map map=new HashMap();
        map.put("code",SUCCESS_CODE);
        map.put("msg","成功");
        return map;
    }
    /**
     * 返回失败
     * */
    public static Map<String,Object> retrunFail(){
        Map map=new HashMap();
        map.put("code",FAIL_CODE);
        map.put("msg","失败");
        return map;
    }
    /**
     * 返回成功消息
     * */
    public static Map<String,Object> retrunSucessMsg(String msg){
        Map map=new HashMap();
        map.put("code",SUCCESS_CODE);
        map.put("msg",msg);
        return map;
    }
    /**
     * 返回失败消息
     * */
    public static Map<String,Object> retrunFailMsg(String msg){
        Map map=new HashMap();
        map.put("code",FAIL_CODE);
        map.put("msg",msg);
        return map;
    }
    /**
     * 返回成功消息和数据
     * */
    public static Map<String,Object> retrunSucessMsgData(Object data){
        Map map=new HashMap();
        map.put("code",SUCCESS_CODE);
        map.put("msg","成功");
        map.put("data",data);
        return map;
    }
    /**
     * 返回失败消息和数据
     * */
    public static Map<String,Object> retrunFailMsgData(Object data){
        Map map=new HashMap();
        map.put("code",FAIL_CODE);
        map.put("msg","失败");
        map.put("data",data);
        return map;
    }
    /**
     * 返回成功消息和数据
     * */
    public static Map<String,Object> retrunSucessMsgData(String msg,Object data){
        Map map=new HashMap();
        map.put("code",SUCCESS_CODE);
        map.put("msg",msg);
        map.put("data",data);
        return map;
    }
    /**
     * 返回失败消息和数据
     * */
    public static Map<String,Object> retrunFailMsgData(String msg,Object data){
        Map map=new HashMap();
        map.put("code",FAIL_CODE);
        map.put("msg",msg);
        map.put("data",data);
        return map;
    }
}
