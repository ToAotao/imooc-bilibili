package com.imooc.bilibili.service;

import com.imooc.bilibili.dao.DemoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DemoService {
    @Autowired
    private DemoDao demoDao;

    public Map<String, Object> query(long id) {
        return demoDao.query(id);
    }

}