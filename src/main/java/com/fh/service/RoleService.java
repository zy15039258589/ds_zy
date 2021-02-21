package com.fh.service;

import com.fh.entity.po.Role;
import com.fh.entity.po.UserRole;

import java.util.List;

public interface RoleService {
    List getData();

    void addRole(Role role);

    void updateRole(Role role);

    void roleAddMenu(Integer roleId,Integer[] menuIdArr);

    List<UserRole> queryRoleByUserId(Integer userId);

    void userAddRole(Integer userId, Integer[] userRoleArr);
}
