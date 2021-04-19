package com.goddess.center.user.domain.model;

import com.goddess.framwork.domain.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author 失败女神
 * @email: 18733123202@163.com
 * @date 2021/4/7 下午6:26
 * @Copyright © 女神帮
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DemoEntity extends BaseEntity<DemoEntity> {

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
