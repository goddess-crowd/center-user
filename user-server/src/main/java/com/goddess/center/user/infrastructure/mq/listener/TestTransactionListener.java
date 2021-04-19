package com.goddess.center.user.infrastructure.mq.listener;

import com.goddess.common.exception.AppException;
import com.goddess.common.rocketmq.MyTransactionListener;
import com.goddess.common.util.RandomUtil;
import com.goddess.common.util.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author 失败女神
 * @email: 18733123202@163.com
 * @date 2021/4/17 上午12:39
 * @Copyright © 女神帮
 */
@Slf4j
@Component
public class TestTransactionListener implements MyTransactionListener {

    @Autowired
    RedisUtils redisUtils;

    @Override
    public LocalTransactionState executeLocalTransaction(Message message, Object o) {
        int x = RandomUtil.getFromMinToMaxOneNum(1,10);
        log.info("开始执行本地事务...."+x);
        LocalTransactionState state;
        try{
            //业务逻辑处理事务 提交 回滚

            if(x>=6){
                throw new Exception();
            }
            state = LocalTransactionState.COMMIT_MESSAGE;
            log.info("本地事务已提交。{}",message.getTransactionId());
            redisUtils.set(message.getTransactionId(),"1");
        }catch (Exception e){
            log.info("执行本地事务失败。{}",e);
            state = LocalTransactionState.ROLLBACK_MESSAGE;
        }
        return state;
    }

    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
        log.info("开始回查本地事务状态。{}",messageExt.getTransactionId());
        LocalTransactionState state;
        String transactionId = messageExt.getTransactionId();
        //判断 事务没有提交
        String val = redisUtils.get(messageExt.getTransactionId());
        if (val!=null){
            state = LocalTransactionState.COMMIT_MESSAGE;
        }else {
            state = LocalTransactionState.UNKNOW;
        }
        log.info("结束本地事务状态查询：transactionId:{},state:{}",transactionId,state);
        return state;
    }

}
