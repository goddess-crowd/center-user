package com.goddess.center.user.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.stereotype.Component;

/**
 * @author 失败女神
 * @email: 18733123202@163.com
 * @date 2021/4/7 下午3:39
 * @Copyright © 女神帮
 */
@Component("baseConfig")
public class BaseConfig {
    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;
}
