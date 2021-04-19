package com.goddess.center.user.application.impl;

import com.goddess.center.user.application.inter.DemoAppService;
import com.goddess.center.user.convertor.DemoConvertor;
import com.goddess.center.user.infrastructure.persistence.dao.DemoMapper;
import com.goddess.center.user.infrastructure.persistence.po.DemoPo;
import com.goddess.center.user.dto.req.DemoReqDto;
import com.goddess.center.user.dto.res.DemoResDto;
import com.goddess.center.user.infrastructure.repository.DemoRepository;
import com.goddess.common.web.PageResult;
import com.goddess.framwork.application.BaseAppService;
import com.goddess.framwork.infrastructure.persistence.BasePService;
import com.goddess.framwork.infrastructure.persistence.IPService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author 失败女神
 * @email: 18733123202@163.com
 * @date 2021/4/8 上午10:30
 * @Copyright © 女神帮
 */
@Slf4j
@Service("demoAppService")
public class DemoAppServiceImpl extends BaseAppService implements DemoAppService {
    @Autowired
    private DemoRepository demoRepository;
    @Autowired
    private DemoConvertor demoConvertor;
    private IPService<DemoPo> poIPService;
    @Autowired
    public DemoAppServiceImpl(DemoConvertor demoConvertor,DemoRepository demoRepository,DemoMapper demoMapper) {
        super(demoConvertor,demoRepository);
        this.poIPService = new BasePService(demoMapper);
    }

//    @Override
//    public PageResult<DemoResDto> getDemoPage(Map<String, Object> params) {
//        PageResult<DemoPo> poPage = poIPService.queryPage(params, DemoPo.class);
//        return demoConvertor.poPage2ResPage(poPage);
//    }

}
