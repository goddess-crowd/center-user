package com.goddess.center.user.interfaces;

import com.alibaba.nacos.api.exception.NacosException;
import com.goddess.common.startup.ApplicationStartup;
import com.goddess.common.util.RedisUtils;
import com.goddess.common.util.SpringBootBeanUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.redis.core.RedisTemplate;

//开启服务注册发现功能
@EnableDiscoveryClient
//bean 扫描
@SpringBootApplication(scanBasePackages = {"com.goddess"})
//mybatis dao扫描
@MapperScan("com.goddess.center.user.infrastructure.persistence.dao*")
//开启扫描 FeignClient
@EnableFeignClients("com.goddess.center.user.infrastructure.acl.feign")
public class UserApplication {

	private static final Logger logger = LoggerFactory.getLogger(UserApplication.class);

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(UserApplication.class);
		springApplication.addListeners(new ApplicationStartup());
		springApplication.run(args);
	}
}
