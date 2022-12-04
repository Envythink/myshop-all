package com.kenbings.shop.shopredis.service;

import com.kenbings.shop.shopredis.mbg.model.PmsBrand;

import java.util.List;

/**
 * 品牌管理Service
 */
public interface PmsBrandService {
    /**
     * 查询所有的品牌信息
     */
    List<PmsBrand> listAllBrand();

    /**
     * 创建一个新品牌
     */
    int createBrand(PmsBrand pmsBrand);

    /**
     * 修改一个品牌信息
     */
    int updateBrand(Long id,PmsBrand pmsBrand);

    /**
     * 删除一个品牌
     */
    int deleteBrand(Long id);

    /**
     * 分页查询品牌信息
     */
    List<PmsBrand> listBrand(int pageNum, int pageSize);

    /**
     * 获取某个品牌信息
     */
    PmsBrand getBrand(Long id);
}