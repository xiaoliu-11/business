package com.example.business.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.business.entity.UserOrderPO;
import com.example.business.mapper.UserOrderPOMapper;
import com.example.business.service.UserOrderPOService;
import com.example.business.utils.BeanCopyUtils;
import com.example.business.utils.OrderUtils;
import com.example.business.vo.order.UserOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserOrderPOServiceImpl extends ServiceImpl<UserOrderPOMapper, UserOrderPO> implements UserOrderPOService {

    @Autowired
    private  UserOrderPOService userOrderPOService;

    @Autowired
    private UserOrderPOMapper userOrderPOMapper;

    @Autowired
    private OrderUtils orderUtils;


    //保存或者修改订单
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveOrUpdateOrder(UserOrderVO userOrderVO) {
        // 保存或修改订单
        UserOrderPO userOrderPO = BeanCopyUtils.copyObject(userOrderVO, UserOrderPO.class);

        List<UserOrderPO> orderByDesc = userOrderPOMapper.getOrderByDesc();
        String sortOrderNumber = orderUtils.getSortOrderNumber(orderByDesc);
        userOrderPO.setOrderId(sortOrderNumber);
        return userOrderPOService.saveOrUpdate(userOrderPO);
    }


    //分页查询订单
    @Override
    public List<UserOrderPO> getUserOrderPage(int current, int size) {
        //1.创建page对象
        //传入两个参数：当前页，每页数量
        Page<UserOrderPO> page = new Page<>(current,size);
        //调用mp的分页查询方法
        //把分页数据封装到page对象里面。
        userOrderPOMapper.selectPage(page,null);
        return page.getRecords();
    }


}
