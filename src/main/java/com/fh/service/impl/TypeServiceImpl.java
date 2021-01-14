package com.fh.service.impl;

import com.fh.dao.TypeDao;
import com.fh.entity.po.Type;
import com.fh.service.TypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Resource
    TypeDao typeDao;


    @Override
    public List<Type> getData() {
        List<Type> list=typeDao.getData();
        return list;
    }

    @Override
    public List getDataByPid(Integer pid) {
        List<Type> list=typeDao.getDataByPid(pid);
        return list;
    }

    @Override
    public Integer add(Type type) {
        type.setCreateDate(new Date());
        type.setIsDel(0);
        typeDao.add(type);
        return type.getId();
    }

    @Override
    public void update(Type type) {
        typeDao.update(type);
    }
}
