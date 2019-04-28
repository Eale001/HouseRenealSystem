package com.eale.hrsm.service;

import com.eale.hrsm.bean.Region;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description 地区Service
 * @author: Eale
 * @date:2019/4/28/028-15:16
 */
@Service
@Transactional
public interface RegionService {

    /**
     * @return com.eale.hrsm.bean.Region
     * @description 根据ID查询
     * @date: 2019/4/28/028 15:17
     * @author: Eale
     * @prams [regionId]
     */
    Region findbyId(Long regionId);

    /**
     * @return void
     * @description 保存
     * @date: 2019/4/28/028 15:20
     * @author: Eale
     * @prams [region]
     */
    void save(Region region);

    /**
     * @description   修改
     * @date: 2019/4/28/028 15:20
     * @author: Eale
     * @prams [region]
     * @return com.eale.hrsm.bean.Region
     */
    Region update(Region region);

    /**
     * @description   查询全部
     * @date: 2019/4/28/028 15:21
     * @author: Eale
     * @prams []
     * @return java.util.List<com.eale.hrsm.bean.Region>
     */
    List<Region> findAll();

    /**
     * @description   条件查询
     * @date: 2019/4/28/028 15:21
     * @author: Eale
     * @prams [region]
     * @return java.util.List<com.eale.hrsm.bean.Region>
     */
    List<Region> findByCondition(Region region);



}