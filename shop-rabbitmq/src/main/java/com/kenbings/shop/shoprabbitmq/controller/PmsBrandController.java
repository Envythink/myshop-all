package com.kenbings.shop.shoprabbitmq.controller;

import com.kenbings.shop.shoprabbitmq.service.PmsBrandService;
import com.kenbings.shop.shoprabbitmq.common.api.CommonPage;
import com.kenbings.shop.shoprabbitmq.common.api.CommonResult;
import com.kenbings.shop.shoprabbitmq.mbg.model.PmsBrand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 品牌管理Controller
 */
@Api(tags = "PmsBrandController",description = "商品品牌管理")
@RestController
@RequestMapping("/brand")
public class PmsBrandController {
    @Autowired
    private PmsBrandService pmsBrandService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    /**
     * 查询所有的品牌信息
     */
    @ApiOperation("获取所有的品牌信息")
    @GetMapping("/listAll")
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public CommonResult<List<PmsBrand>> getBrandList(){
        return CommonResult.success(pmsBrandService.listAllBrand());
    }

    /**
     * 创建一个新品牌
     */
    @ApiOperation("添加品牌")
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('pms:brand:create')")
    public CommonResult createBrand(@RequestBody PmsBrand pmsBrand){
        CommonResult commonResult;
        int count = pmsBrandService.createBrand(pmsBrand);
        if(count==1){
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.debug("品牌创建成功:{}",pmsBrand);
        }else{
            commonResult = CommonResult.failed("品牌创建失败");
            LOGGER.debug("品牌创建失败:{}",pmsBrand);
        }
        return commonResult;
    }

    /**
     * 修改一个品牌信息
     */
    @ApiOperation("更新指定id的品牌信息")
    @PostMapping("/update/{id}")
    @PreAuthorize("hasAuthority('pms:brand:update')")
    public CommonResult updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrandDTO, BindingResult result){
        CommonResult commonResult;
        if(result.hasErrors()){
            commonResult = CommonResult.failed(result.getFieldError().getDefaultMessage());
            return commonResult;
        }
        int count = pmsBrandService.updateBrand(id,pmsBrandDTO);
        if(count==1){
            commonResult = CommonResult.success(pmsBrandDTO);
            LOGGER.debug("品牌修改成功:{}",pmsBrandDTO);
        }else{
            commonResult = CommonResult.failed("品牌修改失败");
            LOGGER.debug("品牌修改失败:{}",pmsBrandDTO);
        }
        return commonResult;
    }

    /**
     * 删除一个品牌
     */
    @ApiOperation("删除指定id的品牌")
    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('pms:brand:delete')")
    public CommonResult deleteBrand(@PathVariable("id") Long id){
        CommonResult commonResult;
        int count = pmsBrandService.deleteBrand(id);
        if(count==1){
            commonResult = CommonResult.success(null);
            LOGGER.debug("品牌删除成功:{}",id);
        }else{
            commonResult = CommonResult.failed("品牌修改失败");
            LOGGER.debug("品牌删除失败:{}",id);
        }
        return commonResult;
    }

    /**
     * 分页查询品牌信息
     */
    @ApiOperation("分页查询品牌列表")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public CommonResult<CommonPage<PmsBrand>> listBrand(
            @RequestParam(value = "pageNum",defaultValue = "1")
            @ApiParam("页码")Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "5")
            @ApiParam("每页数量") Integer pageSize
    ){
        List<PmsBrand> pmsBrands = pmsBrandService.listBrand(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(pmsBrands));
    }

    /**
     * 获取某个品牌信息
     */
    @ApiOperation("获取指定id的品牌详情")
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public CommonResult<PmsBrand> getBrand(@PathVariable("id")Long id){
        return CommonResult.success(pmsBrandService.getBrand(id));
    }
}