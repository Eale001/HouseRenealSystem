package com.eale.hrsm.service;

import com.eale.hrsm.bean.Contract;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description
 * @author: Eale
 * @date:2019/4/28/028-21:30
 */
@Service
@Transactional
public interface ContractService {

    /**
     * @description   根据Id查找
     * @date: 2019/4/28/028 21:31
     * @author: Eale
     * @prams [ctId]
     * @return com.eale.hrsm.bean.Contract
     */
    Contract findById(Long ctId);

    /**
     * @description   保存
     * @date: 2019/4/28/028 21:32
     * @author: Eale
     * @prams [contract]
     * @return void
     */
    void save(Contract contract);

    /**
     * @description   更新
     * @date: 2019/4/28/028 21:32
     * @author: Eale
     * @prams [contract]
     * @return com.eale.hrsm.bean.Contract
     */
    Contract update(Contract contract);

    /**
     * @description   查询全部
     * @date: 2019/4/28/028 21:34
     * @author: Eale
     * @prams []
     * @return java.util.List<com.eale.hrsm.bean.Contract>
     */
    List<Contract> findAll();

    /**
     * @description   条件查询
     * @date: 2019/4/28/028 21:34
     * @author: Eale
     * @prams [contract]
     * @return java.util.List<com.eale.hrsm.bean.Contract>
     */
    List<Contract> findByCondition(Contract contract);

}
