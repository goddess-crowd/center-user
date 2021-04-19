package com.goddess.center.user.interfaces;


import com.goddess.center.user.dto.req.DemoReqDto;
import com.goddess.center.user.dto.res.DemoResDto;
import com.goddess.center.user.es.res.DemoEsResDto;
import com.goddess.common.web.PageResult;
import com.goddess.common.web.ResultResponse;

import java.util.Map;


public interface DemoApi {

    ResultResponse<DemoResDto> addDemo(DemoReqDto reqDto);

    ResultResponse<Void> deleteDemo(String ids);

    ResultResponse<DemoResDto> selectById(Long id);

    ResultResponse<PageResult<DemoResDto>> getPage(Map<String, Object> params);

    ResultResponse<DemoResDto> updateByMap(Long id, Map<String, Object> params);

//    ResultResponse<PageResult<DemoEsResDto>> initDemoToEs(Long id);


}
