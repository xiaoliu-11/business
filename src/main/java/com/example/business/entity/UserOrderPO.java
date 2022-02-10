package com.example.business.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/*
 * @author liushuguo
 * @creed: Talk is cheap,show me the code
 * @date 2022/2/8 15:40
 */



@Data
@TableName("user_order")
public class UserOrderPO {

     private int id;

     @TableField(fill = FieldFill.INSERT) //字段自动填充,订单流水id
     private String orderId;

     private String conUsername;

     private String  supplier;

     private BigDecimal money;

     private String startPlace;

     private String destination;

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
