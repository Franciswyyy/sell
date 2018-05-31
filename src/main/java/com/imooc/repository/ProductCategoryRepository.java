package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    //通过类目编号去查找list   通过传int类型的list去一个
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
