package com.fh.service;

import com.fh.entity.po.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    void userAdd(User user);

    Map login(String name, String password);

    List<User> queryUser();
}
