package com.example.business.vo.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author: 刘树国
 * @create: 2022-02-25
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "根据{承运商}订单分页")
public class OrderPageSupplierResVO {

    /**
     * 承运商
     */
    @NotNull(message = "承运商不能为空")
    @ApiModelProperty(name = "supplier", value = "承运商", required = true, dataType = "String")
    private String supplier;


    /**
     * 当前页
     */
    @NotNull(message = "当前页不能为空")
    @ApiModelProperty(name = "current", value = "当前页", required = true, dataType = "long")
    private long current;


    /**
     * 每页显示记录数
     */
    @NotNull(message = "每页显示记录数不能为空")
    @ApiModelProperty(name = "size", value = "每页显示记录数", required = true, dataType = "long")
    private long size;


}
