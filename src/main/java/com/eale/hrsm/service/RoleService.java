package com.eale.hrsm.service;

import com.eale.hrsm.bean.Role;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface RoleService {

    /**
     * 分页查询role
     * @param page
     * @param size
     * @return
     */
    Page<Role> findAll(int page, int size);

    /**
     * 按名字分页查询
     * @param val
     * @param page
     * @param size
     * @return
     */
    Page<Role> findbyrolename(String val, int page, int size);

    /**
     *
     * 根据Id查询
     * @param roleid
     * @return
     */
    Role findById(Long roleid);

    /**
     * 保存
     * @param roles
     * @return
     */
    Role save(Role roles);

    /**
     * 删除
     * @param r
     */
    void delete(Role r);

    /**
     * 全部查询
     * @return
     */
    List<Role> findAll();
}
