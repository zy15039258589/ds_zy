package com.fh.dao;

import com.fh.entity.po.Brand;
import com.fh.entity.vo.BrandParams;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BrandDao {
    @Select("<script> select count(*) from ds_brand where isdel=0 " +
            "<if test='name!=null and name!=&quot;&quot;'> and name=#{name} </if>" +
            "</script>")
    Long getBrandDateCount(BrandParams params);
    @Select("<script> select * from ds_brand where isdel=0 " +
            "<if test='name!=null and name!=&quot;&quot;'> and name=#{name} </if>" +
            "limit  #{startIndex},#{limit}"+
            "</script>")
    List<Brand> getBrandDateList(BrandParams params);
    @Update("update ds_brand set name=#{name},bandE=#{bandE},imgpath=#{imgpath}," +
            "bandDesc=#{bandDesc},ord=#{ord},isdel=#{isdel},createDate=#{createDate},author=#{author}" +
            "   where id=#{id}")
    void updateBrand(Brand brand);
    @Insert("insert into ds_brand (name,bandE,imgpath,bandDesc,ord,isdel,updateDate,author) value(" +
            "#{name},#{bandE},#{imgpath},#{bandDesc},#{ord},#{isdel},#{updateDate},#{author} )")
    void addBrand(Brand brand);
    @Update("update ds_brand set isdel=1 where id=#{id}")
    void delete(Integer id);
    @Select("select * from ds_brand where isDel=0")
    List<Brand> queryBrand();
}
