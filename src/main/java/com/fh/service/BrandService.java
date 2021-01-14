package com.fh.service;

import com.fh.entity.po.Brand;
import com.fh.entity.vo.BrandParams;
import com.fh.entity.vo.PageResult;

public interface BrandService {
    PageResult getBrandDate(BrandParams params);

    void updateBrand(Brand brand);

    void addBrand(Brand brand);

    void delete(Integer id);
}
