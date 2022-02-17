package com.example.business.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: 刘树国
 * @create: 2022-02-17
 */
@Data
@TableName("user_operationlog")
@AllArgsConstructor
@NoArgsConstructor
public class OperationLogPO {

    private int id;

    private String operator;

    private String operateMethod;

    private String operateType;

    private String params;

    private String operateResult;

    private String operateIp;

    //创建时间
    @TableField(fill = FieldFill.INSERT) //字段自动填充
    private Date gmtCreate;

    //修改时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtUpdate;

    //逻辑删除位
    @TableLogic
    @TableField( fill= FieldFill.INSERT)
    private Integer isDeleted;
}
