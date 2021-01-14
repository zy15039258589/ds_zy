package com.fh.service;

import com.fh.entity.po.Property;
import com.fh.entity.vo.PageResult;
import com.fh.entity.vo.PropertyParams;

public interface PropertyService {
    PageResult getData(PropertyParams params);

    void add(Property property);

    void update(Property property);
}