package com.eale.hrsm.service;

import com.eale.hrsm.bean.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description
 * @author: Eale
 * @date:2019/4/28/028-21:35
 */
@Service
@Transactional
public interface OrderService {

    /**
     * @description   根据Id查询
     * @date: 2019/4/28/028 21:35
     * @author: Eale
     * @prams [orderId]
     * @return com.eale.hrsm.bean.Order
     */
    Order findById(Long orderId);

    /**
     * @description   保存
     * @date: 2019/4/28/028 21:36
     * @author: Eale
     * @prams [order]
     * @return void
     */
    void save(Order order);

    /**
     * @description   修改
     * @date: 2019/4/28/028 21:36
     * @author: Eale
     * @prams [order]
     * @return com.eale.hrsm.bean.Order
     */
    Order update(Order order);

    /**
     * @description   查找全部
     * @date: 2019/4/28/028 21:37
     * @author: Eale
     * @prams []
     * @return java.util.List<com.eale.hrsm.bean.Order>
     */
    List<Order> findAll();

    /**
     * @description   根据条件查询
     * @date: 2019/4/28/028 21:38
     * @author: Eale
     * @prams [order]
     * @return java.util.List<com.eale.hrsm.bean.Order>
     */
    List<Order> findByCondition(Order order);



}
