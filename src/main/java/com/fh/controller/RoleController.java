package com.fh.controller;

import com.fh.entity.po.Role;
import com.fh.entity.po.UserRole;
import com.fh.entity.vo.ResultData;
import com.fh.service.RoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("RoleController")
public class RoleController {
    @Resource
    RoleService roleService;


    @GetMapping("getData")
    public ResultData getData(){
        List list=roleService.getData();
        return ResultData.success(list);
    };
    @PostMapping("addRole")
    public ResultData addRole(Role role){
        roleService.addRole(role);
        return ResultData.success(null);
    }

    @PostMapping("updateRole")
    public ResultData updateRole(Role role){
        roleService.updateRole(role);
        return ResultData.success(null);
    }

    //角色添加权限
    @GetMapping("roleAddMenu")
    public ResultData roleAddMenu(Integer roleId,Integer[] menuIdArr){
        roleService.roleAddMenu(roleId,menuIdArr);
        return  ResultData.success(null);
    }

    //根据用户id查询有的角色
    @GetMapping("queryRoleByUserId")
    public ResultData queryRoleByUserId(Integer userId){
        List<UserRole> list=roleService.queryRoleByUserId(userId);
        return  ResultData.success(list);
    }

    //用户添加角色
    @GetMapping("userAddRole")
    public ResultData userAddRole(Integer[] userRoleArr,Integer userId){
        roleService.userAddRole(userId,userRoleArr);
        return  ResultData.success(null);
    }

}
