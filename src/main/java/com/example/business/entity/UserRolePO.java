package com.example.business.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author: 刘树国
 * @create: 2022-02-16
 */
@Data
@TableName("user_user_role")
public class UserRolePO {

    private Integer id;

    private Integer userid;

    private Integer roleid;
    //创建时间
    @TableField(fill = FieldFill.INSERT) //字段自动填充
    private Date gmtCreate;

    //修改时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtUpdate;

}
