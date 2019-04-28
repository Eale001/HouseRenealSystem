package com.eale.hrsm.service.impl;

import com.eale.hrsm.bean.Role;
import com.eale.hrsm.dao.RoleDao;
import com.eale.hrsm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Page<Role> findAll(int page, int size) {
        Pageable pageable= PageRequest.of(page,size);
        return roleDao.findAll(pageable);
    }

    @Override
    public Page<Role> findbyrolename(String val, int page, int size) {
        Pageable pageable= PageRequest.of(page,size);
        return roleDao.findbyrolename(val,pageable);
    }

    @Override
    public Role findById(Long roleid) {
        return roleDao.findById(roleid).get();
    }

    @Override
    public Role save(Role roles) {
        roleDao.save(roles);
        return roleDao.findById(roles.getRoleId()).get();
    }

    @Override
    public void delete(Role r) {
        roleDao.delete(r);
    }

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }
}
