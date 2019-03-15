package com.wzj.web.controller;
import com.wzj.model.Admin;
import com.wzj.service.service.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by Zongjie Wu on 2019/03/03.
 */
@Controller
@RequestMapping("/admin/")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("login")
    @ResponseBody
    public Map<String,Object> login(Map<String,Object> paramMap){
        Map<String,Object> map=new HashMap<String,Object>();
        return map;
    }

    @RequestMapping("add")
    @ResponseBody
    public String add(Admin admin) {
        adminService.save(admin);
        return "";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(@RequestParam Integer id) {
	    adminService.deleteById(id);
	    return "";
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(Admin admin) {
	    adminService.update(admin);
	    return "";
    }

    @RequestMapping("detail")
    @ResponseBody
    public String detail(@RequestParam Integer id) {
        Admin admin = adminService.findById(id);
        return admin.toString();
    }

    @RequestMapping("list")
    @ResponseBody
    public String list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Admin> list = adminService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return list.toString();
    }
}
