package com.goddess.center.user.infrastructure.persistence.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.goddess.framwork.infrastructure.persistence.po.BasePo;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author 失败女神
 * @email: 18733123202@163.com
 * @date 2021/4/7 下午6:30
 * @Copyright © 女神帮
 */
@Data
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@TableName(value = "user_demo", resultMap = "demoMap")
public class DemoPo extends BasePo<DemoPo> implements Serializable{
    private static final long serialVersionUID = 1L;

    public DemoPo(){

    }
    public DemoPo(Long id){
        this.id = id;
    }

    /**
     * 日期 DATE
     */
    private LocalDate localDate;
    /**
     * 时间 TIME
     */
    private LocalTime localTime;
    /**
     * 日期时间 TIMESTAMP
     */
    private LocalDateTime localDateTime;
    /**
     * 零售价 DECIMAL
     */
    private BigDecimal retailPrice;
    /**
     * 进货价 DECIMAL
     */
    private BigDecimal purchasePrice;
    /**
     * 批发价 DECIMAL
     */
    private BigDecimal wholesalePrice;
    /**
     * 备注 VARCHAR
     */
    private String remarks;

}

