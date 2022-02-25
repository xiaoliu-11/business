package com.example.business.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author: 刘树国
 * @create: 2022-02-25
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "给用户分配角色")
public class UserRoleReqVO {
    /**
     * 用户id
     */
    @NotNull(message = "用户名id不能为空")
    @ApiModelProperty(name = "userid", value = "用户名id", required = true, dataType = "Integer")
    private Integer userid;


    /**
     * 角色id不能为空
     */
    @NotNull(message = "角色id不能为空")
    @ApiModelProperty(name = "roleid", value = "角色id", required = true, dataType = "Integer")
    private Integer roleid;


}
