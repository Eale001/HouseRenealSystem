package com.eale.hrsm.dao;

import com.eale.hrsm.bean.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description
 * @author: Eale
 * @date:2019/4/28/028-21:30
 */
public interface OrderDao extends JpaRepository<Order,Long> {
}
