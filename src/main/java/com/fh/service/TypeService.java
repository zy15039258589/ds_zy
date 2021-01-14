package com.fh.service;

import com.fh.entity.po.Type;

import java.util.List;

public interface TypeService {
    List<Type> getData();

    List getDataByPid(Integer pid);

    Integer add(Type type);

    void update(Type type);
}
