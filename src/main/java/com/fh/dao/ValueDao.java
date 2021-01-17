package com.fh.dao;

import com.fh.entity.po.Value;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ValueDao {
    @Select("select * from ds_value where propertyId=#{propertyId}")
    List<Value> getData(Integer propertyId);
}
