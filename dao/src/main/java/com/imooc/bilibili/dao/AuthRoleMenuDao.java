package com.imooc.bilibili.dao;

import com.imooc.bilibili.domain.auth.AuthRoleMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Set;

@Mapper
public interface AuthRoleMenuDao {
    public List<AuthRoleMenu> getAuthRoleMenuByRoleIds(Set<Long> roleIdSet);
}
