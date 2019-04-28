package com.eale.hrsm.service.impl;

import com.eale.hrsm.bean.District;
import com.eale.hrsm.bean.House;
import com.eale.hrsm.dao.HouseDao;
import com.eale.hrsm.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description
 * @author: Eale
 * @date:2019/4/28/028-15:44
 */
@Service
@Transactional
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseDao houseDao;


    @Override
    public House finbById(Long houseId) {
        return houseDao.findById(houseId).get();
    }

    @Override
    public void save(House house) {
        houseDao.save(house);
    }

    @Override
    public House update(House house) {
        houseDao.save(house);
        return houseDao.findById(house.getHouseId()).get();
    }

    @Override
    public List<House> fingAll() {
        return houseDao.findAll();
    }

    @Override
    public List<House> findByContions(House house) {
        org.springframework.data.domain.Example<House> example= Example.of(house);
        return houseDao.findAll(example);
    }
}
