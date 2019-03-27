package com.wzj.web.controller;
import com.wzj.model.Admin;
import com.wzj.service.service.AdminService;
import com.wzj.enums.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by Zongjie Wu on 2019/03/26.
 */
@RestController
@RequestMapping("/admin/")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("add")
    public Map<String,Object> add(Admin admin) {
        System.out.println(10/0);
        adminService.save(admin);
        return Result.retrunSucess();
    }

    @RequestMapping("delete")
    public Map<String,Object> delete(@RequestParam Long id) {
	    adminService.deleteById(id);
	    return Result.retrunSucess();
    }

    @RequestMapping("update")
    public Map<String,Object> update(Admin admin) {
	    adminService.update(admin);
	    return Result.retrunSucess();
    }

    @RequestMapping("detail")
    public Map<String,Object> detail(@RequestParam Long id) {
        Admin admin = adminService.findById(id);
        return Result.retrunSucessMsgData(admin);
    }

    @RequestMapping("list")
    public Map<String,Object> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer limit) {
        PageHelper.startPage(page, limit);
        List<Admin> list = adminService.findAll();
        List list1=new ArrayList();
        PageInfo pageInfo = new PageInfo(list);
        Map<String,Object> map=Result.retrunSucessMsgData(pageInfo.getList());
        map.put("count",pageInfo.getTotal());
        return map;
    }
}
