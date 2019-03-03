package com.wzj.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexAction {
    @RequestMapping("")
    public String jumpIndexPage(){
        return "WEB-INF/views/admin/index";
    }
}
