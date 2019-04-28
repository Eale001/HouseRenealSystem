package com.eale.hrsm.service.impl;

import com.eale.hrsm.bean.District;
import com.eale.hrsm.bean.House;
import com.eale.hrsm.dao.DistrictDao;
import com.eale.hrsm.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @description
 * @author: Eale
 * @date:2019/4/28/028-15:28
 */
@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictDao districtDao;

    @Override
    public District findById(Long districtId) {
        return districtDao.findById(districtId).get();
    }

    @Override
    public void save(District district) {
        districtDao.save(district);
    }

    @Override
    public District update(District district) {
        districtDao.save(district);
        return districtDao.findById(district.getDistrictId()).get();
    }

    @Override
    public List<District> findAll() {
        return districtDao.findAll();
    }

    @Override
    public List<District> findByConditions(District district) {
        Example<District> example=Example.of(district);
        return districtDao.findAll(example);
    }
}
