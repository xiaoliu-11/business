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


}
