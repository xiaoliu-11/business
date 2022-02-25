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
@ApiModel(description = "根据用户名订单分页")
public class OrderPageUsernameResVO {

    /**
     *用户名
     */
    @NotNull(message = "用户名不能为空")
    @ApiModelProperty(name = "username", value = "用户名", required = true, dataType = "String")
    private String username;


    /**
     *当前页
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
