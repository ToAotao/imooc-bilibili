package com.imooc.bilibili.dao;

import com.alibaba.fastjson.JSONObject;
import com.imooc.bilibili.domain.User;
import com.imooc.bilibili.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
import java.util.Set;


@Mapper
public interface UserDao {
    User getUserByPhone(String phone);
    Integer addUser (User user);
    Integer addUserInfo(UserInfo userInfo);
    User getUserById(Long id);

    UserInfo getUserInfoByUserId(Long userId);

    Integer updateUserInfos(UserInfo userInfo);

    Integer updateUsers(User user);

    List<UserInfo> getUserInfoByUserIds(Set<Long> userIdList);

    Integer pageCountUserInfos(Map<String, Object> params);

    List<UserInfo> pageListUserInfos(Map<String, Object> params);
}
