package com.wzj.web.catalog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AdminCatalogController {
    /**
     *跳转至登入页
     * */
    @RequestMapping("")
    public String jumpLoginPage(){
        return "WEB-INF/views/admin/login";
    }
    /**
     *跳转至登入页
     * */
    @RequestMapping("admin/jumpIndexPage")
    public String jumpAdminIndexPage(){
        return "WEB-INF/views/admin/index";
    }
    /**
     *跳转至忘记密码页
     * */
    @RequestMapping("admin/jumpForgetPage")
    public String jumpAdminForgetPage(){
        return "WEB-INF/views/admin/forget";
    }
}
