package com.wzj.web.catalog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/")
public class AdminCatalog {
    /**
     *跳转至登入页
     * */
    @GetMapping("/jumpLogin")
    public String jumpLoginPage(){
        return "WEB-INF/views/admin/login";
    }
    /**
     *跳转至登入页
     * */
    @GetMapping("/jumpIndex")
    public String jumpIndexPage(){
        return "WEB-INF/views/admin/index";
    }
    /**
     *跳转至忘记密码页
     * */
    @GetMapping("/jumpForget")
    public String jumpForgetPage(){
        return "WEB-INF/views/admin/forget";
    }
    /**
     *跳转至注册页面
     * */
    @GetMapping("/jumpRegister")
    public String jumpRegister(){
        return "WEB-INF/views/admin/register";
    }
}
