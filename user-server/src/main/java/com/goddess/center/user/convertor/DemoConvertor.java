package com.goddess.center.user.convertor;

import com.goddess.center.user.domain.model.DemoEntity;
import com.goddess.center.user.infrastructure.persistence.po.DemoPo;
import com.goddess.center.user.dto.req.DemoReqDto;
import com.goddess.center.user.dto.res.DemoResDto;
import com.goddess.framwork.convertor.IConvertor;
import org.mapstruct.Mapper;

/**
 * @author 失败女神
 * @email: 18733123202@163.com
 * @date 2021/4/7 下午6:32
 * @Copyright © 女神帮
 */
@Mapper(componentModel="spring")
public abstract class DemoConvertor implements IConvertor<DemoReqDto, DemoResDto, DemoEntity, DemoPo> {

}
