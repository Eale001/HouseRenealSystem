package com.eale.hrsm.service.impl;

import com.eale.hrsm.bean.Contract;
import com.eale.hrsm.bean.District;
import com.eale.hrsm.dao.ContractDao;
import com.eale.hrsm.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description
 * @author: Eale
 * @date:2019/4/28/028-21:39
 */
@Service
@Transactional
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractDao contractDao;

    @Override
    public Contract findById(Long ctId) {
        return contractDao.findById(ctId).get();
    }

    @Override
    public void save(Contract contract) {
        contractDao.save(contract);
    }

    @Override
    public Contract update(Contract contract) {
        contractDao.save(contract);
        return contractDao.findById(contract.getContractId()).get();
    }

    @Override
    public List<Contract> findAll() {
        return contractDao.findAll();
    }

    @Override
    public List<Contract> findByCondition(Contract contract) {
        Example<Contract> example=Example.of(contract);
        return contractDao.findAll(example);
    }
}
