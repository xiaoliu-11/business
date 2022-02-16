package com.example.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.business.entity.UserOrderPO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description 用户信息Mapper
 * @Author liushuguo
 * @CreateTime 2022/02/08
 */


@Repository
public interface UserOrderPOMapper extends BaseMapper<UserOrderPO> {


    //根据订单号降序查询订单数据，该方法用来生成递增的流水号
    List<UserOrderPO> getOrderByDesc();

   //根据用户名查询该用户所有订单
    List<UserOrderPO> listUserOrderByUsername(String username);


    //根据用户名查询该用户所有订单+分页
    List<UserOrderPO> listUserOrderByUsernamePage(String username,int current,int size);


    //根据供应商查询该用户所有订单
    List<UserOrderPO> listUserOrderBySupplier(String supplier);


    //根据供应商查询该用户所有订单+分页
    List<UserOrderPO> listUserOrderBySupplierPage(String supplier,int current,int size);



}
