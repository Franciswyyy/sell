package com.imooc.repository;

import com.imooc.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, String>{

    // 查询状态的商品   0是上架状态 1是下架
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
