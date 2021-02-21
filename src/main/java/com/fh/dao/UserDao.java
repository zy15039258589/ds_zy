package com.fh.dao;

import com.fh.entity.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Mapper
@ResponseBody
public interface UserDao {

    @Insert("insert into ds_user (name,realName,password,sex,phone,email,idCard,birthday,imgUrl,eduId" +
            ",deptId,createDate)" +
            " value(#{name},#{realName},#{password},#{sex},#{phone},#{email},#{idCard},#{birthday},#{imgUrl},#{eduId},#{deptId},#{createDate})")
    void userAdd(User user);
    @Select("select * from ds_user where name=#{name}")
    User login(String name);
    @Select("select * from ds_user")
    List<User> queryUser();
}
