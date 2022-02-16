package com.example.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.business.entity.UserOrderPO;
import com.example.business.vo.order.UserOrderVO;

import java.util.List;

public interface UserOrderPOService extends IService<UserOrderPO> {

    /*
       添加或者修改订单
     */

    boolean saveOrUpdateOrder(UserOrderVO userOrderVO);


    /*
      TODO 分页查询
     */

    List<UserOrderPO> getUserOrderPage(int current, int size);

    ////根据用户名查询该用户所有订单
    List<UserOrderPO> listUserOrderByUsername(String username);

    //根据用户名查询该用户所有订单+分页
    List<UserOrderPO> listUserOrderByUsernamePage(String username,int current,int size);

    //根据供应商查询该用户所有订单
    List<UserOrderPO> listUserOrderBySupplier(String supplier);


    //根据供应商查询该用户所有订单+分页
    List<UserOrderPO> listUserOrderBySupplierPage(String supplier,int current,int size);

}
