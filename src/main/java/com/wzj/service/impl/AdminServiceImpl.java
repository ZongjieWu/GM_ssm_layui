package com.wzj.service.impl;

import com.wzj.dao.mapper.AdminMapper;
import com.wzj.model.Admin;
import com.wzj.service.service.AdminService;
import com.wzj.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by Zongjie Wu on 2019/03/03.
 */
@Service
public class AdminServiceImpl extends AbstractService<Admin> implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

}
