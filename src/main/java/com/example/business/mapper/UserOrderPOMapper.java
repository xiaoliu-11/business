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
}
