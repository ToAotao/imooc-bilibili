package com.imooc.bilibili.domain.auth;

import lombok.Data;

import java.util.Date;
@Data
public class AuthRoleMenu {
    private Long id;
    private Long roleId;
    private Long menuId;
    private AuthMenu authMenu;
    private Date createTime;
}
