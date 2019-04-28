package com.eale.hrsm.service.impl;

import com.eale.hrsm.bean.Order;
import com.eale.hrsm.dao.OrderDao;
import com.eale.hrsm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description
 * @author: Eale
 * @date:2019/4/28/028-21:44
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public Order findById(Long orderId) {
        return orderDao.findById(orderId).get();
    }

    @Override
    public void save(Order order) {
        orderDao.save(order);
    }

    @Override
    public Order update(Order order) {
        orderDao.save(order);
        return orderDao.findById(order.getOrderId()).get();
    }

    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    @Override
    public List<Order> findByCondition(Order order) {
        Example<Order> example=Example.of(order);
        return orderDao.findAll(example);
    }
}
