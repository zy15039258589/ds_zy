package com.fh.dao;

import com.fh.entity.po.Menu;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MenuDao {
    @Select("select * from ds_menu where isDel=0")
    List<Menu> getData();
    @Update("update ds_menu set name=#{name},url=#{url},isDel=#{isDel} where id=#{id}")
    void updateMenu(Menu menu);
    @Insert("insert into ds_menu (pid,name,url,type,isDel,createDate,author) value" +
            "(#{pid},#{name},#{url},#{type},#{isDel},#{createDate},#{author})")
    void addMenu(Menu menu);
}
