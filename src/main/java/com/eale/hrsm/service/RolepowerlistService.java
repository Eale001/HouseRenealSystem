package com.eale.hrsm.service;

import com.eale.hrsm.bean.Role;
import com.eale.hrsm.bean.Rolemenu;
import com.eale.hrsm.bean.Rolepowerlist;
import com.eale.hrsm.bean.SystemMenu;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface RolepowerlistService {

    /**
     * 找所有的父菜单
     * @param id
     * @param roleid
     * @return
     */
    List<Rolemenu> findbyparentall(long id, Long roleid);

    /**
     * 找所又子菜单
     * @param l
     * @param roleid
     * @return
     */
    List<Rolemenu> findbyparents(long l, Long roleid);

    /**
     * 根据roleid 和menuId查询
     * @param roleid
     * @param menuid
     * @return
     */
    Rolepowerlist findbyroleidandmenuid(Long roleid, Long menuid);

    /**
     * 保存单个
     * @param rolepower
     */
    void save(Rolepowerlist rolepower);

    /**
     * 保存多个
     * @param menulist
     * @param rolep
     * @return
     */
     void save(List<SystemMenu> menulist, Role rolep);

    /**
     * 条件查找父菜单
     * @param l
     * @param roleId
     * @param b
     * @param b1
     * @param val
     * @return
     */
    List<Rolemenu> findname(long l, Long roleId, boolean b, boolean b1, String val);

    /**
     * 找所有可显示的子菜单
     * @param menuId
     * @param roleId
     * @param b
     * @param b1
     * @return
     */
//    List<Rolemenu> findbyparentxianall(Long menuId, Long roleId, boolean b, boolean b1);
    List<Rolemenu> findbyparentsxian(Long menuId, Long roleId, boolean b, boolean b1);
}
