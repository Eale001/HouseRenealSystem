package com.eale.hrsm.service;

import com.eale.hrsm.bean.House;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description
 * @author: Eale
 * @date:2019/4/28/028-12:19
 */
@Service
public interface HouseService {

    /**
     * @description   根据Id查询
     * @date: 2019/4/28/028 15:04
     * @author: Eale
     * @prams [houseId]
     * @return com.eale.hrsm.bean.House
     */
    House finbById(Long houseId);

    /**
     * @description   保存house
     * @date: 2019/4/28/028 15:05
     * @author: Eale
     * @prams [house]
     * @return void
     */
    void save(House house);

    /**
     * @description   修改House
     * @date: 2019/4/28/028 15:06
     * @author: Eale
     * @prams [house]
     * @return com.eale.hrsm.bean.House
     */
    House update(House house);

    /**
     * @description   查询全部房源
     * @date: 2019/4/28/028 15:07
     * @author: Eale
     * @prams []
     * @return java.util.List<com.eale.hrsm.bean.House>
     */
    List<House> fingAll();

    /**
     * @description   根据条件查询
     * @date: 2019/4/28/028 15:08
     * @author: Eale
     * @prams [house]
     * @return java.util.List<com.eale.hrsm.bean.House>
     */
    List<House> findByContions(House house);



}
