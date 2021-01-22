package com.fh.service;

import com.fh.entity.po.Value;

import java.util.List;
import java.util.Map;

public interface ValueService {

    List<Value> getData(Integer id);

    void add(Value value);

    void update(Value value);

    void delete(Integer id);

    Map queryByTypeId(Integer typeId);
}
