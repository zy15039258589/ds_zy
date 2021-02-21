package com.fh.utils;

import java.util.HashMap;
import java.util.Map;

public class TestJwt {

    public  void  createToken(){
        //JWTtoken有三部分组成
        //头部信息
        Map<String,Object> headMap=new HashMap<>();
        headMap.put("alg","HS256");
        headMap.put("type","JWT");

        //设置有效负载 一般放一些用户信息
        Map payloadMap=new HashMap();
        payloadMap.put("userId","225");
        payloadMap.put("userName","张三");


        //设置失效时间
        long startTime=System.currentTimeMillis();
        long expTime=startTime+60000l;

        //生成jwt

    }

}
