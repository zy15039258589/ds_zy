package com.fh.service.impl;

import com.fh.dao.RoleDao;
import com.fh.entity.po.Role;
import com.fh.entity.po.RoleMenu;
import com.fh.entity.po.UserRole;
import com.fh.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    RoleDao roleDao;

    @Override
    public List getData() {
        List<Role> list=roleDao.getData();
        return list;
    }

    @Override
    public void addRole(Role role) {
        role.setCreateDate(new Date());
        roleDao.addRole(role);
    }

    @Override
    public void updateRole(Role role) {
        roleDao.updateRole(role);
    }

    @Override
    @Transactional  //加上事务   什么是事务
    public void roleAddMenu(Integer roleId,Integer[] menuIdArr) {
        roleDao.deleteRoleMenu(roleId);
        List<RoleMenu> list=new ArrayList();
        for (int i = 0; i <menuIdArr.length ; i++) {
            RoleMenu roleMenu=new RoleMenu();
            roleMenu.setRid(roleId);
            roleMenu.setMid(menuIdArr[i]);
            list.add(roleMenu);
        }
        roleDao.roleAddMenu(list);
    }

    @Override
    public List<UserRole> queryRoleByUserId(Integer userId) {
        List<UserRole> list=roleDao.queryRoleByUserId(userId);
        return list;
    }

    @Override
    @Transactional  //加上事务   什么是事务
    public void userAddRole(Integer userId, Integer[] userRoleArr) {
        //先删
        roleDao.deleteUserRole(userId);
        List<UserRole> list=new ArrayList();
        for (int i = 0; i <userRoleArr.length ; i++) {
            UserRole userRole=new UserRole();
            userRole.setUid(userId);
            userRole.setRid(userRoleArr[i]);
            list.add(userRole);
        }
        roleDao.userAddRole(list);
    }
}
