package com.eale.hrsm.dao;

import com.eale.hrsm.bean.House;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description
 * @author: Eale
 * @date:2019/4/28/028-12:21
 */
public interface HouseDao extends JpaRepository<House,Long> {
}
