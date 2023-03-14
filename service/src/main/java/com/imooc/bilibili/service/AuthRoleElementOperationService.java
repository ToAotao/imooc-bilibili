package com.imooc.bilibili.service;

import com.imooc.bilibili.dao.AuthElementOperationDao;
import com.imooc.bilibili.domain.auth.AuthElementOperation;
import com.imooc.bilibili.domain.auth.AuthRoleElementOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AuthRoleElementOperationService {
    @Autowired
    private AuthElementOperationDao authElementOperationDao;
    public List<AuthRoleElementOperation> getRoleElementOperationsByRoleIds(Set<Long> roleIdSet) {
        return authElementOperationDao.getRoleElementOperationsByRoleIds(roleIdSet);
    }
}
