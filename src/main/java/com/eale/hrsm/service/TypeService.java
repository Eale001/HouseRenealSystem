package com.eale.hrsm.service;

import com.eale.hrsm.bean.Type;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description  房屋类型Service
 * @author: Eale
 * @date:2019/4/28/028-15:23
 */
@Service
@Transactional
public interface TypeService {

    /**
     * @description   根据id查询
     * @date: 2019/4/28/028 15:23
     * @author: Eale
     * @prams [typeId]
     * @return com.eale.hrsm.bean.Type
     */
    Type findById(Long typeId);

    /**
     * @description   保存
     * @date: 2019/4/28/028 15:24
     * @author: Eale
     * @prams [type]
     * @return void
     */
    void save(Type type);

    /**
     * @description   修改
     * @date: 2019/4/28/028 15:25
     * @author: Eale
     * @prams [type]
     * @return com.eale.hrsm.bean.Type
     */
    Type update(Type type);

    /**
     * @description   查询全部
     * @date: 2019/4/28/028 15:25
     * @author: Eale
     * @prams []
     * @return java.util.List<com.eale.hrsm.bean.Type>
     */
    List<Type> findAll();

    /**
     * @description   根据条件查询
     * @date: 2019/4/28/028 15:26
     * @author: Eale
     * @prams [type]
     * @return java.util.List<com.eale.hrsm.bean.Type>
     */
    List<Type> findByConditions(Type type);



}
