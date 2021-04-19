package com.goddess.center.user.infrastructure.persistence.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.goddess.center.user.infrastructure.persistence.po.DemoPo;
import com.goddess.framwork.infrastructure.persistence.dao.BaseExtMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 失败女神
 * @email: 18733123202@163.com
 * @date 2021/4/7 下午7:45
 * @Copyright © 女神帮
 */
@Mapper
public interface DemoMapper extends BaseMapper<DemoPo> {

}
