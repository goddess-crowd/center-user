package com.goddess.center.user.infrastructure.repository;

import com.goddess.center.user.convertor.DemoConvertor;
import com.goddess.center.user.domain.model.DemoEntity;
import com.goddess.center.user.domain.repository.DemoQuery;
import com.goddess.center.user.infrastructure.persistence.dao.DemoMapper;
import com.goddess.center.user.infrastructure.persistence.po.DemoPo;
import com.goddess.framwork.infrastructure.persistence.IPService;
import com.goddess.framwork.infrastructure.repository.BaseRepository;
import com.goddess.framwork.infrastructure.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 失败女神
 * @email: 18733123202@163.com
 * @date 2021/4/7 下午7:48
 * @Copyright © 女神帮
 */
@org.springframework.stereotype.Repository
public class DemoRepository extends BaseRepository implements Repository<DemoEntity,DemoPo>, DemoQuery {
    private DemoMapper demoMapper;
    private IPService<DemoPo> demoPoService;

    @Autowired
    public DemoRepository(DemoMapper demoMapper,DemoConvertor demoConvertor) {
        super(demoConvertor,demoMapper);
        this.demoPoService = super.getIPService();
        this.demoMapper = demoMapper;
    }

    @Override
    public Class getPoClass() {
        return DemoPo.class;
    }
}
