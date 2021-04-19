package com.goddess.center.user.infrastructure.es.service;

import com.goddess.center.user.es.req.DemoESReqDto;
import com.goddess.center.user.es.res.DemoEsResDto;

import java.util.List;

/**
 * @author 失败女神
 * @email: 18733123202@163.com
 * @date 2021/4/19 上午10:43
 * @Copyright © 女神帮
 */
public interface DemoEsService {
    List<DemoEsResDto> getSalesQtySkc(DemoESReqDto demoESReqDto);
    DemoEsResDto initDemoToEs(Long id);
}
