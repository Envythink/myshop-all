package com.kenbings.shop.shopmongodb.controller;

import com.kenbings.shop.shopmongodb.service.UmsMemberService;
import com.kenbings.shop.shopmongodb.common.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 会员管理Controller
 */
@Api(tags = "UmsMemberController",description = "会员登录注册管理")
@RestController
@RequestMapping("/sso")
public class UmsMemberController {
    @Autowired
    private UmsMemberService umsMemberService;

    @ApiOperation("获取验证码")
    @GetMapping("/getAuthCode")
    public CommonResult getAuthCode(@RequestParam @ApiParam("手机号")String telephone){
        return umsMemberService.generateAuthCode(telephone);
    }

    @ApiOperation("校验验证码是否正确")
    @PostMapping("/verifyAuthCode")
    public CommonResult verifyAuthCode(@RequestParam @ApiParam("手机号")String telephone,@ApiParam("验证码")@RequestParam String authCode){
        return umsMemberService.verifyAuthCode(telephone,authCode);
    }
}