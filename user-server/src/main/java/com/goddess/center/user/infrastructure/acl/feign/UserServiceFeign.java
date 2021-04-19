package com.goddess.center.user.infrastructure.acl.feign;

import com.goddess.common.web.ResultResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 失败女神
 * @email: 18733123202@163.com
 * @date 2021/4/9 下午11:30
 * @Copyright © 女神帮
 */
@FeignClient("user-service")
//@FeignClient(name = "user-service",url = "http://127.0.0.1:12003")
public interface UserServiceFeign {

    @GetMapping(value = "/user/demo/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResultResponse getDemoById(@PathVariable("id") Long id);

}