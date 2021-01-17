package com.fh.service.impl;

import com.fh.dao.ValueDao;
import com.fh.entity.po.Value;
import com.fh.service.ValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ValueServiceImpl implements ValueService {
    @Resource
    ValueDao valueDao;

    @Override
    public List<Value> getData(Integer propertyId) {
        List<Value> list=valueDao.getData(propertyId);
        return list;
    }

    @Override
    public void add(Value value) {
        valueDao.add(value);
    }

    @Override
    public void update(Value value) {
        valueDao.update(value);
    }

    @Override
    public void delete(Integer id) {
        valueDao.delete(id);
    }
}
