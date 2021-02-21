package com.fh.dao;

import com.fh.entity.po.Role;
import com.fh.entity.po.UserRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleDao {
    @Select("select * from ds_role")
    List<Role> getData();
    @Insert("insert into ds_role (name,isDel,createDate,author) value (#{name},#{isDel},#{createDate},#{author})")
    void addRole(Role role);
    @Update("update ds_role set name=#{name},isDel=#{isDel},author=#{author} where id=#{id}")
    void updateRole(Role role);
    //角色权限
    @Insert("<script>insert into ds_roleMenu  (rid,mid)" +
            " values <foreach collection='list' item='a' separator=','>(#{a.rid},#{a.mid})" +
            "</foreach>"+
            " </script>")
    void roleAddMenu(List list);

    @Delete("delete from ds_roleMenu where rid=#{roleId}")
    void deleteRoleMenu(Integer roleId);
    //用户角色
    @Select("select * from ds_userRole where uid=#{userId}")
    List<UserRole> queryRoleByUserId(Integer userId);
    @Delete("delete from ds_userRole where uid=#{userId}")
    void deleteUserRole(Integer userId);

    @Insert("<script>insert into ds_userRole  (uid,rid)" +
            " values <foreach collection='list' item='a' separator=','>(#{a.uid},#{a.rid})" +
            "</foreach>"+
            " </script>")
    void userAddRole(List<UserRole> list);
}
