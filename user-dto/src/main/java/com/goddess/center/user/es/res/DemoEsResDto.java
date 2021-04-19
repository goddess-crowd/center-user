package com.goddess.center.user.es.res;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.goddess.framwork.api.dto.IRequestDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel
public class DemoEsResDto implements IRequestDto {
    private static final long serialVersionUID = 1L;

    /**
     * 日期 DATE
     */
    @ApiModelProperty(value = "日期", example = "yyyy-MM-dd")
    @JsonProperty(index = 10)
    private LocalDate localDate;
    /**
     * 时间 TIME
     */
    @ApiModelProperty(value = "时间", example = "HH:mm:ss", dataType = "java.lang.String")
    @JsonProperty(index = 20)
    private LocalTime localTime;
    /**
     * 日期时间 TIMESTAMP
     */
    @ApiModelProperty(value = "日期时间")
    @JsonProperty(index = 30)
    private LocalDateTime localDateTime;
    /**
     * 零售价 DECIMAL
     */
    @ApiModelProperty(value = "零售价")
    @JsonProperty(index = 40)
    private BigDecimal retailPrice;
    /**
     * 进货价 DECIMAL
     */
    @ApiModelProperty(value = "进货价")
    @JsonProperty(index = 50)
    private BigDecimal purchasePrice;
    /**
     * 批发价 DECIMAL
     */
    @ApiModelProperty(value = "批发价")
    @JsonProperty(index = 60)
    private BigDecimal wholesalePrice;
    /**
     * 备注 VARCHAR
     */
    @ApiModelProperty(value = "备注")
    @JsonProperty(index = 70)

    private String remarks;

    /**
     * pk BIGINT
     */
    @ApiModelProperty(value = "ID")
    @JsonProperty(index = 0)
    private Long id;
    /**
     * 创建人 VARCHAR
     */
    @ApiModelProperty(value = "创建人")
    @JsonProperty(index = 100)
    private String createUserId;
    /**
     * 创建时间 TIMESTAMP
     */
    @ApiModelProperty(value = "创建时间")
    @JsonProperty(index = 110)
    private LocalDateTime createTime;
    /**
     * 修改人 VARCHAR
     */
    @ApiModelProperty(value = "修改人")
    @JsonProperty(index = 120)
    private String modifyUserId;
    /**
     * 修改时间 TIMESTAMP
     */
    @ApiModelProperty(value = "修改时间")
    @JsonProperty(index = 130)
    private LocalDateTime modifyTime;


}






