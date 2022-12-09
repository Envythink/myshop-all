package com.kenbings.shop.shoprabbitmq.controller;

import com.kenbings.shop.shoprabbitmq.dto.OrderParam;
import com.kenbings.shop.shoprabbitmq.service.OmsPortalOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 前台订单管理的Controller
 */
@Api(tags = "OmsPortalOrderController",description = "订单管理")
@RestController
@RequestMapping("/order")
public class OmsPortalOrderController {
    @Autowired
    private OmsPortalOrderService omsPortalOrderService;

    @ApiOperation("根据购物车信息生成订单")
    @PostMapping("/generateOrder")
    public Object generateOrder(@RequestBody OrderParam orderParam) {
        return omsPortalOrderService.generateOrder(orderParam);
    }
}