package com.goddess.center.user.interfaces.rest;

import com.goddess.center.user.application.inter.DemoAppService;
import com.goddess.center.user.dto.req.DemoReqDto;
import com.goddess.center.user.dto.res.DemoResDto;
import com.goddess.center.user.infrastructure.acl.feign.UserServiceFeign;
import com.goddess.center.user.infrastructure.mq.listener.TestTransactionListener;
import com.goddess.center.user.interfaces.DemoApi;
import com.goddess.common.rocketmq.RocketMqProducer;
import com.goddess.common.web.PageResult;
import com.goddess.common.web.ResultResponse;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.Map;

/**
 * @author 失败女神
 * @email: 18733123202@163.com
 * @date 2021/4/7 下午12:02
 * @Copyright © 女神帮
 */
@Slf4j
@Api(tags = {"mq示例"})
@RestController
@RequestMapping("/mq")
public class MqApiController  {
    @Autowired
    private DemoAppService demoAppService;
    @Autowired
    private TestTransactionListener testTransactionListener;
    @Autowired
    private RocketMqProducer rocketMqProducer;

    @ApiOperation(value = "发送消息", tags = {"mq示例"}, nickname = "send")
    @GetMapping(value = "/{msg}", produces = {"application/json"})
    public ResultResponse<DemoResDto> send(
            @ApiParam(value = "消息", required = true) @PathVariable("msg") String msg) {
//        log.info("=====================同步消息开始");
//        String msgId = rocketMqProducer.sendMsg("test","test01","同步"+msg);
//        log.info("=====================同步消息结束 msgId：{}",msgId);
//
//        log.info("=====================异步消息开始");
//        rocketMqProducer.sendMsgAsy("test","test02","异步"+msg);
//        log.info("=====================异步消息结束");
//
//        log.info("=====================单向消息开始");
//        rocketMqProducer.sendMsgOneway("test","test03","单向"+msg);
//        log.info("=====================单向消息结束");

        log.info("=====================事务消息开始");
        rocketMqProducer.sendMsgTransaction(testTransactionListener,
                "test","test04",msg);
        log.info("=====================事务消息结束");
        return ResultResponse.ok();
    }

}
