package com.fh.dao;

import com.fh.entity.po.Property;
import com.fh.entity.vo.PropertyParams;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PropertyDao {
    @Select("<script>" +
            "select count(*) from ds_property where isDel=0 " +
            " <if test='name!=null and name!=&quot;&quot;'> and name=#{name} </if> " +
            "</script>")
    Long getDataCount(PropertyParams params);
    @Select("<script>" +
            "select * from ds_property where isDel=0" +
            "<if test='name!=null and name!=&quot;&quot;'> and name=#{name} </if>" +
            " limit  #{startIndex},#{limit}" +
            "</script>")
    List<Property> getDataList(PropertyParams params);
}
