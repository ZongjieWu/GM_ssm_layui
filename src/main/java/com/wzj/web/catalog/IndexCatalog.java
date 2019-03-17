package com.wzj.web.catalog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class IndexCatalog {
    /**
     *跳转至登入页
     * */
    @GetMapping("")
    public String jumpLoginPage(){
        return "WEB-INF/views/admin/login";
    }
}
