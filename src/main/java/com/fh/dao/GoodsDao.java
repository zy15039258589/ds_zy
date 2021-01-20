package com.fh.dao;

import com.fh.entity.po.Goods;
import com.fh.entity.vo.BrandParams;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface GoodsDao {
    @Insert("insert  into ds_goods  (name,title,bandId,typeId,productdecs,price,imgPath,stocks,sortNum,createDate,author,isDel)" +
            " value(#{name},#{title},#{bandId},#{typeId},#{productdecs},#{price},#{imgPath},#{stocks},#{sortNum},#{createDate},#{author},#{isDel})")
   void addGoods(Goods goods);
    @Update("update ds_goods set name=#{name},title=#{title},bandId=#{bandId},typeId=#{typeId}," +
            "productdecs=#{productdecs},price=#{price},imgPath=#{imgPath},stocks=#{stocks},sortNum=#{sortNum},createDate=#{createDate},updateDate=#{updateDate},author=#{author}" +
            " where id=#{id}")
    void updateGoods(Goods goods);
    @Update("update ds_goods set isDel=1 where id=#{id}")
    void deleteGoods(Integer id);
    @Select("<script>" +
            "select count(*) from ds_goods where 1=1" +
             "<if test='name!=null and name!=&quot;&quot;'>and name=#{name} </if>"+
            "</script>")
    Long selectGoodsCount(BrandParams params);
    @Select("<script>" +
            "select * from ds_goods where 1=1" +
            "<if test='name!=null and name!=&quot;&quot;'>and name=#{name} </if>"+
            " limit  #{startIndex},#{limit}"+
            "</script>")
    List<Goods> selectGoodsList(BrandParams params);
}
