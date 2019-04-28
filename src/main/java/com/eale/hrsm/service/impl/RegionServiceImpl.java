package com.eale.hrsm.service.impl;

import com.eale.hrsm.bean.Region;
import com.eale.hrsm.dao.RegionDao;
import com.eale.hrsm.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description
 * @author: Eale
 * @date:2019/4/28/028-15:49
 */
@Service
@Transactional
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionDao regionDao;

    @Override
    public Region findbyId(Long regionId) {
        return regionDao.findById(regionId).get();
    }

    @Override
    public void save(Region region) {
        regionDao.save(region);
    }

    @Override
    public Region update(Region region) {
        regionDao.save(region);
        return regionDao.findById(region.getRegionId()).get();
    }

    @Override
    public List<Region> findAll() {
        return regionDao.findAll();
    }

    @Override
    public List<Region> findByCondition(Region region) {
        Example<Region> example=Example.of(region);
        return regionDao.findAll(example);
    }
}
