package com.example.business.vo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 刘树国
 * @create: 2022-02-10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "返回用户属于哪个角色")
public class UserRoleVO {

    @ApiModelProperty(name = "id", value = "用户id", dataType = "Integer")
    private int id;

    @ApiModelProperty(name = "username", value = "用户名", dataType = "String")
    private String username;

    @ApiModelProperty(name = "roleId",value = "角色id",dataType = "Integer")
    private int roleId;

    @ApiModelProperty(name = "role", value = "角色名", dataType = "String")
    private String role;

}
