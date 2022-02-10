package com.example.business.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: 刘树国
 * @create: 2022-02-10
 */
@Data
@TableName("user_permission")
@AllArgsConstructor
@NoArgsConstructor
public class PermissionPO {


    private int id;

    private String permission;

    private String description;

    //创建时间
    @TableField(fill = FieldFill.INSERT) //字段自动填充
    private Date gmtCreate;

    //修改时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtUpdate;

}
