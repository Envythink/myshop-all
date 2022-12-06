package com.kenbings.shop.shopelasticsearch.service.impl;

import com.kenbings.shop.shopelasticsearch.common.api.CommonResult;
import com.kenbings.shop.shopelasticsearch.service.RedisService;
import com.kenbings.shop.shopelasticsearch.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;

/**
 * 会员管理Service实现类
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    @Autowired
    private RedisService redisService;
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        String authCode = stringBuilder.toString();
        //验证码+手机号作为Key存储到Redis中
        String redisKey = REDIS_KEY_PREFIX_AUTH_CODE + telephone;
        redisService.set(redisKey,authCode);
        redisService.expire(redisKey,AUTH_CODE_EXPIRE_SECONDS);
        return CommonResult.success(authCode,"验证码获取成功");
    }

    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        if(StringUtils.isEmpty(authCode)){
            return CommonResult.failed("请输入验证码");
        }
        String redisKey = REDIS_KEY_PREFIX_AUTH_CODE + telephone;
        String redisAuthCode = redisService.get(redisKey);
        if(StringUtils.isEmpty(redisAuthCode)){
            return CommonResult.failed("验证码已过期");
        }
        boolean result = authCode.equals(redisAuthCode);
        if(result){
            return CommonResult.success(null,"验证码校验成功");
        }else {
            return CommonResult.failed("验证码不正确");
        }
    }
}