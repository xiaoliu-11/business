package com.example.business.vo.order;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;




/*
 *
 * @author liushuguo
 * @creed: Talk is cheap,show me the code
 * @date 2022/2/8 17:34
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "订单")
public class UserOrderVO {


    /**
     * 订单id
     */
    @ApiModelProperty(name = "id", value = "订单id", dataType = "int")
    private int id;


    @NotBlank(message = "货主不能为空")
    @ApiModelProperty(name = "conUsername", value = "货主", dataType = "String")
    private String conUsername;

    @NotBlank(message = "供应商不能为空")
    @ApiModelProperty(name = "supplier", value = "供应商", dataType = "String")
    private String  supplier;


    @NotBlank(message = "金额不能为空")
    @ApiModelProperty(name = "money", value = "金额", dataType = "BigDecimal")
    private BigDecimal money;

    @NotBlank(message = "出发地点不能为空")
    @ApiModelProperty(name = "startPlace", value = "出发地", dataType = "String")
    private String startPlace;


    @NotBlank(message = "目的地不能为空")
    @ApiModelProperty(name = "destination", value = "目的地", dataType = "String")
    private String destination;



}
