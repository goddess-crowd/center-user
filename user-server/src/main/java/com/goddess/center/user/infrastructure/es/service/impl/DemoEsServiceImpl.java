package com.goddess.center.user.infrastructure.es.service.impl;

import com.goddess.center.user.domain.model.DemoEntity;
import com.goddess.center.user.es.req.DemoESReqDto;
import com.goddess.center.user.es.res.DemoEsResDto;
import com.goddess.center.user.exception.EnumException;
import com.goddess.center.user.infrastructure.es.index.DemoIndex;
import com.goddess.center.user.infrastructure.es.service.DemoEsService;
import com.goddess.center.user.infrastructure.persistence.po.DemoPo;
import com.goddess.center.user.infrastructure.repository.DemoRepository;
import com.goddess.common.exception.AppException;
import com.goddess.es.client.ElasticsearchTemplate;
import com.goddess.es.client.util.QueryBuilderUtil;
import com.google.common.collect.Lists;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author 失败女神
 * @email: 18733123202@163.com
 * @date 2021/4/19 上午10:43
 * @Copyright © 女神帮
 */
@Component
public class DemoEsServiceImpl implements DemoEsService {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    private DemoRepository demoRepository;
    @Override
    public List<DemoEsResDto> getSalesQtySkc(DemoESReqDto demoESReqDto) {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        commonPackageParams(demoESReqDto,boolQueryBuilder);

//        elasticsearchTemplate.
        return null;
    }

    @Override
    public DemoEsResDto initDemoToEs(Long id) {
        DemoEntity entity = demoRepository.selectById(id);
        if(entity ==null ){
            return null;
        }
        DemoIndex demoIndex = new DemoIndex();
        BeanUtils.copyProperties(entity,demoIndex);
        elasticsearchTemplate.save(demoIndex);
        DemoEsResDto demoEsResDto = new DemoEsResDto();
        BeanUtils.copyProperties(demoIndex,demoEsResDto);
        return demoEsResDto;
    }

    /**
     * 公共查询条件，返回分组字段
     *
     * @return
     */
    private String[] commonPackageParams(Object obj, BoolQueryBuilder boolQueryBuilder) {
        List<String> groupField = Lists.newArrayList();
        Field[] field = obj.getClass().getDeclaredFields();
        try {
            for (Field f : field) {
                String name = f.getName();
                if ("serialVersionUID".equals(name)) {
                    continue;
                }
                Method m = obj.getClass().getMethod("get" + name.substring(0, 1).toUpperCase() + name.substring(1));
                Object value = m.invoke(obj);
                if (value instanceof List) {
                    QueryBuilderUtil.addTermsQueryQuery(name, (List) value, boolQueryBuilder);
                    groupField.add(name);
                }
                if (value instanceof String) {
                    QueryBuilderUtil.addTermQueryQuery(name, value, boolQueryBuilder);
                }
            }
        } catch (Exception e) {
            throw new AppException(EnumException.EXCEPTION_1000.getMsg(), EnumException.EXCEPTION_1000.getCode());
        }
        return groupField.toArray(new String[groupField.size()]);
    }
}
