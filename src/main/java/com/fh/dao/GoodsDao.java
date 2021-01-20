package com.fh.dao;

import com.fh.entity.po.Goods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsDao {
    @Insert("insert  into ds_goods  (name,title,bandId,typeId,productdecs,price,imgPath,stocks,sortNum,createDate,updateDate,author,isDel)" +
            " value(#{name},#{title},#{bandId},#{typeId},#{productdecs},#{price},#{imgPath},#{stocks},#{sortNum},#{createDate},#{updateDate},#{author},#{isDel})")
   void addGoods(Goods goods);
}
