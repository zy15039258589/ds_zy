package com.fh.dao;

import com.fh.entity.po.Type;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TypeDao {
    @Select("select * from ds_type where isDel=0")
    List<Type> getData();
    @Select("select * from ds_type where pid=#{pid} and isDel=0")
    List<Type> getDataByPid(Integer pid);

    void add(Type type);
    @Update("update ds_type set name=#{name},updateDate=#{updateDate},isDel=#{isDel} where id=#{id}")
    void update(Type type);
}
