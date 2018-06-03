package com.imooc.repository;

import com.imooc.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    // 先从master查订单id ， 再到详情到orderid，  master一条可能对应多条详情的，因此返回list
    List<OrderDetail> findByOrderId(String orderId);
}
