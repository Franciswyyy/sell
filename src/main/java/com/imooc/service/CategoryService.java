package com.imooc.service;

import com.imooc.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {

    //查询一条记录
    ProductCategory findOne(Integer categryId);

    //查询所有。这两个都是个后台管理用的
    List<ProductCategory> findAll();

    //通过type去查，买家查
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);


    //新增和更新
    ProductCategory save(ProductCategory productCategory);
}
