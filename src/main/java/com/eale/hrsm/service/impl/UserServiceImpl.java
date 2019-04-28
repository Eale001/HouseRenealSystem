package com.eale.hrsm.service.impl;

import com.eale.hrsm.bean.User;
import com.eale.hrsm.dao.UserDao;
import com.eale.hrsm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findOneUser(String userName, String password) {
        return userDao.findOneUser(userName,password);
    }

    @Override
    public User findById(Long userid) {
        return userDao.findById(userid).get();
    }

    @Override
    public List<User> findrole(Long lid) {
        return userDao.findrole(lid);
    }

    @Override
    public Page<User> findByIsLock(int i, int page, int size) {
        Pageable pageable= PageRequest.of(page,size);
        return userDao.findByIsLock(i,pageable);
    }

    @Override
    public Page<User> findnamelike(String name, int page, int size) {
        Pageable pageable= PageRequest.of(page,size);
        return userDao.findnamelike(name,pageable);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User findByUserName(String username) {
        return userDao.findByUserName(username);
    }
}
