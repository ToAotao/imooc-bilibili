package com.imooc.bilibili.domain;

import lombok.Data;

import java.util.List;
@Data
public class PageResult <T>{
    private Integer total;
    private List<T> list;

    public PageResult(Integer total, List<T> list) {
        this.list = list;
        this.total = total;
    }
}
