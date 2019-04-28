package com.eale.hrsm.service;

import com.eale.hrsm.bean.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface UserService {
    /**
     * 根据用户名和密码查询用户
     * 登录查询
     * @param userName
     * @param password
     * @return
     */
    User findOneUser(String userName, String password);

    /**
     * 根据ID查询
     * @param userid
     * @return
     */
    User findById(Long userid);

    /**
     * 根据roleId查询user
     * @param lid
     * @return
     */
    List<User> findrole(Long lid);

    /**
     * 分页查询未锁用户
     * @param i
     * @param page
     * @param size
     * @return
     */
    Page<User> findByIsLock(int i, int page, int size);

    /**
     * 根据名字分页查询
     * @param usersearch
     * @param page
     * @param size
     * @return
     */
    Page<User> findnamelike(String usersearch, int page, int size);

    /**
     * 保存用户
     * @param user
     */
    void save(User user);

    /**
     * 根据用户名查找
     * @param username
     * @return
     */
    User findByUserName(String username);
}
