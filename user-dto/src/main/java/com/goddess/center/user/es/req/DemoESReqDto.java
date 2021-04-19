package com.goddess.center.user.es.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.goddess.framwork.api.dto.IResponseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
public class DemoESReqDto implements IResponseDto {
    private static final long serialVersionUID = 1L;

    /**
     * 备注 VARCHAR
     */
    @ApiModelProperty(value = "备注")
    @JsonProperty(index = 70)
    private String remarks;
}






