package com.eale.hrsm.service.impl;

import com.eale.hrsm.bean.Type;
import com.eale.hrsm.dao.TypeDao;
import com.eale.hrsm.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description
 * @author: Eale
 * @date:2019/4/28/028-15:52
 */
@Service
@Transactional
public class TypeServieImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Override
    public Type findById(Long typeId) {
        return typeDao.findById(typeId).get();
    }

    @Override
    public void save(Type type) {
        typeDao.save(type);
    }

    @Override
    public Type update(Type type) {
        typeDao.save(type);
        return typeDao.findById(type.getTypeId()).get();
    }

    @Override
    public List<Type> findAll() {
        return typeDao.findAll();
    }

    @Override
    public List<Type> findByConditions(Type type) {
        Example<Type> example=Example.of(type);
        return typeDao.findAll(example);
    }
}
