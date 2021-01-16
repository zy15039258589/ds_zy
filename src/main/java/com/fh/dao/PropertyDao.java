package com.fh.dao;

import com.fh.entity.po.Property;
import com.fh.entity.vo.PropertyParams;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PropertyDao {
    @Select("<script>" +
            "select count(*) from ds_property where isDel=0 " +
            " <if test='name!=null and name!=&quot;&quot;'> and nameCH=#{name} </if> " +
            "</script>")
    Long getDataCount(PropertyParams params);
    @Select("<script>" +
            "select * from ds_property where isDel=0" +
            "<if test='name!=null and name!=&quot;&quot;'> and nameCH=#{name} </if>" +
            " limit  #{startIndex},#{limit}" +
            "</script>")
    List<Property> getDataList(PropertyParams params);
    @Insert("insert into ds_property (name,nameCH,typeId,type,isSKU,isDel,createDate,author)" +
            " value(#{name},#{nameCH},#{typeId},#{type},#{isSKU},#{isDel},#{createDate},#{author})")
    void add(Property property);
    @Update("update ds_property set name=#{name},nameCH=#{nameCH},typeId=#{typeId}," +
            " type=#{type},isSKU=#{isSKU},isDel=#{isDel},author=#{author},updateDate=#{updateDate} where id=#{id}")
    void update(Property property);
    @Update("update ds_property set isDel=1 where id=#{id}")
    void delete(Integer id);
}
