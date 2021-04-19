package com.goddess.center.user.dto.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.goddess.framwork.api.dto.IResponseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Validated
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel
public class DemoReqDto implements IResponseDto {
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
    @ApiModelProperty(value = "日期时间", example = "yyyy-MM-ddTHH:mm:ss", dataType = "java.lang.String")
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
}






