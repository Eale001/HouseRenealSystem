package com.eale.hrsm.service.impl;

import com.eale.hrsm.bean.Role;
import com.eale.hrsm.bean.Rolemenu;
import com.eale.hrsm.bean.Rolepowerlist;
import com.eale.hrsm.bean.SystemMenu;
import com.eale.hrsm.dao.RolepowerlistDao;
import com.eale.hrsm.service.RolepowerlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RolepowerlistServiceImpl implements RolepowerlistService {

    @Autowired
    private RolepowerlistDao rolepowerlistDao;

    @Override
    public List<Rolemenu> findbyparentall(long id, Long roleid) {
        return rolepowerlistDao.findbyparentall(id,roleid);
    }

    @Override
    public List<Rolemenu> findbyparents(long id, Long roleid) {
        return rolepowerlistDao.findbyparents(id,roleid);
    }

    @Override
    public Rolepowerlist findbyroleidandmenuid(Long roleid, Long menuid) {
        return rolepowerlistDao.findbyroleidandmenuid(roleid,menuid);
    }

    @Override
    public void save(Rolepowerlist rolepower) {
        rolepowerlistDao.save(rolepower);
    }

    @Override
    public void save(List<SystemMenu> menulist, Role rolep) {
        for (SystemMenu menu:menulist) {
            rolepowerlistDao.save(new Rolepowerlist(rolep,menu));
        }
    }

    @Override
    public List<Rolemenu> findname(long id, Long roleId, boolean b, boolean b1, String val) {
        return rolepowerlistDao.findname(id,roleId,b,b1,val);
    }

    @Override
    public List<Rolemenu> findbyparentsxian(Long menuId, Long roleId, boolean b, boolean b1) {
        return rolepowerlistDao.findbyparentsxian(menuId,roleId,b,b1);
    }
}
