package cn.practice.test.service;

import cn.practice.test.domian.Users;

public interface UserService {

    Users findUserByUsername(String username);

    Users findOne(Users users);
}
