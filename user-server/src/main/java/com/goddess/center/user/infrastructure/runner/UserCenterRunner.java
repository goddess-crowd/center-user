package com.goddess.center.user.infrastructure.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


/**
 * @author 失败女神
 * @email: 18733123202@163.com
 * @date 2021/4/16 下午5:10
 * @Copyright © 女神帮
 */
@Component
@Slf4j
public class UserCenterRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("项目启动完成执行");
    }
}

