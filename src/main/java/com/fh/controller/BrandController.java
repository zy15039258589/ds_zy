package com.fh.controller;

import com.fh.entity.po.Brand;
import com.fh.entity.vo.BrandParams;
import com.fh.entity.vo.PageResult;
import com.fh.entity.vo.ResultData;
import com.fh.service.BrandService;
import com.fh.utils.OssFileUtils_zy;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("BrandController")
public class BrandController {

    @Resource
    BrandService brandService;

    @PostMapping("getBrandDate")
    public PageResult getBrandDate(BrandParams params){
        PageResult result=brandService.getBrandDate(params);
        return result;
    }
    @PostMapping("updateBrand")
    public ResultData updateBrand(Brand brand){
        if(brand.getId()!=null){
            brandService.updateBrand(brand);
            return ResultData.success(null);
        }else{
            return ResultData.error(500,"没有id");
        }
    }
    @PostMapping("addBrand")
    public ResultData addBrand(Brand brand){
        brandService.addBrand(brand);
        return ResultData.success(null);
    }
    @GetMapping("delete")
    public ResultData delete(Integer id){
        brandService.delete(id);
        return ResultData.success(null);
    }
    @RequestMapping("imgAdd")
    public String imgAdd(MultipartFile file, HttpServletRequest request) throws IOException {
        String originalFilename = file.getOriginalFilename();
        int i = originalFilename.lastIndexOf(".");
        String substring = originalFilename.substring(i);
        String fileName=UUID.randomUUID()+substring;
         String imgPath = OssFileUtils_zy.uploadFile(file.getInputStream(),fileName);
        return imgPath;
    }




}
