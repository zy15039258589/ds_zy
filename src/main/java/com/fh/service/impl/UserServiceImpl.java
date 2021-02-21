package com.fh.service.impl;

import com.fh.dao.UserDao;
import com.fh.entity.po.User;
import com.fh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Resource
    HttpServletRequest request;

    @Override
    public void userAdd(User user) {
        userDao.userAdd(user);
    }

    @Override
    public Map login(String name, String password) {
        Map map=new HashMap();
        User user=userDao.login(name);
        if(user!=null){
            if(user.getPassword().equals(password)){
                map.put("ccg",2);
            }else{
                HttpSession session = request.getSession();
                session.setAttribute("user",user);
                map.put("ccg",1);
            }
        }else{
            map.put("ccg",0);
        }
        return map;
    }

    @Override
    public List<User> queryUser() {
        List<User> list=userDao.queryUser();
        return list;
    }
}
