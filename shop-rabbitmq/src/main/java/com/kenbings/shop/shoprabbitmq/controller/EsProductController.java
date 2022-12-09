package com.kenbings.shop.shoprabbitmq.controller;

import com.kenbings.shop.shoprabbitmq.common.api.CommonPage;
import com.kenbings.shop.shoprabbitmq.common.api.CommonResult;
import com.kenbings.shop.shoprabbitmq.domain.EsProductRelatedInfo;
import com.kenbings.shop.shoprabbitmq.nosql.elasticsearch.document.EsProduct;
import com.kenbings.shop.shoprabbitmq.service.EsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品搜索管理Controller
 */
@Api(tags = "EsProductController",description = "商品搜索管理")
@RestController
@RequestMapping("/esProduct")
public class EsProductController {
    @Autowired
    private EsProductService esProductService;

    @ApiOperation(value = "导入所有数据库中商品到ES")
    @PostMapping("/importAll")
    public CommonResult<Integer> importAllList() {
        int count = esProductService.importAll();
        return CommonResult.success(count);
    }

    @ApiOperation(value = "根据id删除Es中指定的商品信息")
    @GetMapping("/delete/{id}")
    public CommonResult<Object> delete(@PathVariable Long id) {
        esProductService.delete(id);
        return CommonResult.success(null);
    }

    @ApiOperation(value = "根据id批量删除Es中的商品信息")
    @PostMapping( "/delete/batch")
    public CommonResult<Object> delete(@RequestParam("ids") List<Long> ids) {
        esProductService.delete(ids);
        return CommonResult.success(null);
    }

    @ApiOperation(value = "根据id在ES中创建商品信息")
    @PostMapping( "/create/{id}")
    public CommonResult<EsProduct> create(@PathVariable Long id) {
        EsProduct esProduct = esProductService.create(id);
        if (esProduct != null) {
            return CommonResult.success(esProduct);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "简单搜索")
    @GetMapping("/search/simple")
    public CommonResult<CommonPage<EsProduct>> search(@RequestParam(required = false) @ApiParam("关键字") String keyword,
                                                      @RequestParam(required = false, defaultValue = "0")@ApiParam("页码") Integer pageNum,
                                                      @RequestParam(required = false, defaultValue = "5")@ApiParam("每页数量") Integer pageSize) {
        Page<EsProduct> esProductPage = esProductService.search(keyword, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(esProductPage));
    }

    @ApiOperation(value = "综合搜索、筛选、排序")
    @ApiImplicitParam(name = "sort", value = "排序字段:0->按相关度；1->按新品；2->按销量；3->价格从低到高；4->价格从高到低",
            defaultValue = "0", allowableValues = "0,1,2,3,4", paramType = "query", dataType = "integer")
    @GetMapping("/search")
    public CommonResult<CommonPage<EsProduct>> search(@RequestParam(required = false) @ApiParam("关键字") String keyword,
                                                      @RequestParam(required = false) @ApiParam("品牌id") Long brandId,
                                                      @RequestParam(required = false) @ApiParam("商品类别id") Long productCategoryId,
                                                      @RequestParam(required = false, defaultValue = "0")@ApiParam("页码") Integer pageNum,
                                                      @RequestParam(required = false, defaultValue = "5")@ApiParam("每页数量") Integer pageSize,
                                                      @RequestParam(required = false, defaultValue = "0") @ApiParam("排序字段")Integer sort) {
        Page<EsProduct> esProductPage = esProductService.search(keyword,brandId,productCategoryId,pageNum, pageSize,sort);
        return CommonResult.success(CommonPage.restPage(esProductPage));
    }


    @ApiOperation(value = "根据商品id推荐商品")
    @GetMapping( "/recommend/{id}")
    public CommonResult<CommonPage<EsProduct>> recommend(@PathVariable @ApiParam("商品id") Long id,
                                                         @RequestParam(required = false, defaultValue = "0")@ApiParam("页码") Integer pageNum,
                                                         @RequestParam(required = false, defaultValue = "5")@ApiParam("每页数量") Integer pageSize) {
        Page<EsProduct> esProductPage = esProductService.recommend(id, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(esProductPage));
    }

    @ApiOperation(value = "获取搜索的相关品牌、分类及筛选属性")
    @GetMapping(value = "/search/relate")
    public CommonResult<EsProductRelatedInfo> searchRelatedInfo(@RequestParam(required = false) @ApiParam("关键字") String keyword) {
        EsProductRelatedInfo productRelatedInfo = esProductService.searchRelatedInfo(keyword);
        return CommonResult.success(productRelatedInfo);
    }
}