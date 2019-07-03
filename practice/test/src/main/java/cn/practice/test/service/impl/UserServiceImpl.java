package cn.practice.test.service.impl;

import cn.practice.test.dao.UserDao;
import cn.practice.test.domian.Users;
import cn.practice.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserServiceImpl implements UserService {

    @Resource
    //@Autowired
    private UserDao userDao;

    @Override
    public Users findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    public Users findOne(Users users) {
        return userDao.findOne(users);
    }
}
