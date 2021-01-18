package com.fh.dao;

import com.fh.entity.po.Value;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ValueDao {
    @Select("select * from ds_value where propertyId=#{propertyId} and isDel=0")
    List<Value> getData(Integer propertyId);
    @Insert("insert into ds_value (value,valueCH,propertyId,isDel) value(#{value},#{valueCH},#{propertyId},#{isDel})")
    void add(Value value);
    @Update("update ds_value set value=#{value},valueCH=#{valueCH},propertyId=#{propertyId} where id=#{id}")
    void update(Value value);
    @Update("update ds_value set isDel=1 where id=#{id}")
    void delete(Integer id);
}
