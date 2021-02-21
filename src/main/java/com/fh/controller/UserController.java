package com.fh.controller;

import com.fh.entity.po.User;
import com.fh.entity.vo.ResultData;
import com.fh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("UserController")
@CrossOrigin
public class UserController {
      @Autowired
      UserService userService;

      @RequestMapping("userAdd")
      public ResultData userAdd(User user){
          userService.userAdd(user);
          return ResultData.success(null);
      }
      @PostMapping("login")
      public Map login(String name,String password){
          Map map=userService.login(name,password);
          return map;
      }

    @GetMapping("queryUser")
    public ResultData queryUser(){
        List<User>list =userService.queryUser();
        return ResultData.success(list);
    }


}
