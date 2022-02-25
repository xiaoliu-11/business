package com.example.business.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@TableName("user_info")
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoPO implements Serializable {
    //id作为唯一主键

    private int id;

    private String username;

    private String password;

    private String salt;

    //创建时间
    @TableField(fill = FieldFill.INSERT) //字段自动填充
    private Date gmtCreate;

    //修改时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtUpdate;

    //定义角色集合
    private List<RolePO> roles;

}
