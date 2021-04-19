package com.goddess.center.user.infrastructure.es.index;

import com.goddess.es.client.annotation.ESID;
import com.goddess.es.client.annotation.ESMetaData;
import com.goddess.es.client.annotation.ESMetaData;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Data
@ESMetaData(indexName = "user_demo_index",indexType = "demo", number_of_shards = 3,number_of_replicas = 3,printLog = true)
public class DemoIndex implements Serializable {

    private static final long serialVersionUID = 1L;

    @ESID
    private Long id;

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
