package com.wzj.web.controller;
import com.wzj.enums.Result;
import com.wzj.model.Admin;
import com.wzj.service.service.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by Zongjie Wu on 2019/03/03.
 */
@RestController
@RequestMapping("/admin/")
@Validated
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("login")
    public Map<String,Object> login(@NotNull @NotEmpty String phone,@NotNull @NotEmpty  String pwd){
        Map<String,Object> map=new HashMap<String,Object>();
        return map;
    }

    @RequestMapping("add")
    public Map<String,Object> add(Admin admin) {
        adminService.save(admin);
        return Result.retrunSucess();
    }

    @RequestMapping("delete")
    public Map<String,Object> delete(@RequestParam Integer id) {
	    adminService.deleteById(id);
	    return Result.retrunSucess();
    }

    @RequestMapping("update")
    public Map<String,Object> update(Admin admin) {
	    adminService.update(admin);
	    return Result.retrunSucess();
    }

    @RequestMapping("detail")
    public Map<String,Object> detail(@RequestParam Integer id) {
        Admin admin = adminService.findById(id);
        return Result.retrunSucessMsgData(admin);
    }

    @RequestMapping("list")
    public Map<String,Object> list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Admin> list = adminService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        Map<String,Object> map=Result.retrunSucessMsgData(pageInfo.getList());
        map.put("count",pageInfo.getTotal());
        return map;
    }
}
