package com.kenbings.shop.shopmongodb.service;

import com.kenbings.shop.shopmongodb.common.api.CommonResult;

/**
 * 会员管理Service
 */
public interface UmsMemberService {
    /**
     * 根据手机号生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号是否匹配
     */
    CommonResult verifyAuthCode(String telephone,String authCode);
}