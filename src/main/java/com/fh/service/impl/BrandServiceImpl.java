package com.fh.service.impl;

import com.fh.dao.BrandDao;
import com.fh.dao.TypeDao;
import com.fh.entity.po.Brand;
import com.fh.entity.vo.BrandParams;
import com.fh.entity.vo.PageResult;
import com.fh.service.BrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Resource
    BrandDao brandDao;

    @Override
    public PageResult getBrandDate(BrandParams params) {
        Long count=brandDao.getBrandDateCount(params);
        params.setStartIndex((params.getPage()-1)*params.getLimit());
        List<Brand> list=brandDao.getBrandDateList(params);
        PageResult result=new PageResult();
        result.setMsg("");
        result.setCode(0);
        result.setData(list);
        result.setCount(count);
        return result;
    }

    @Override
    public void updateBrand(Brand brand) {
        brand.setUpdateDate(new Date());
        brand.setIsdel(0);
        brandDao.updateBrand(brand);
    }

    @Override
    public void addBrand(Brand brand) {
        brand.setCreateDate(new Date());
        brand.setIsdel(0);
        brandDao.addBrand(brand);
    }

    @Override
    public void delete(Integer id) {
        brandDao.delete(id);
    }
}
