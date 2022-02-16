package com.example.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.business.entity.UserInfoPO;
import com.example.business.entity.UserOrderPO;
import com.example.business.mapper.UserOrderPOMapper;
import com.example.business.service.UserOrderPOService;
import com.example.business.utils.BeanCopyUtils;
import com.example.business.utils.OrderUtils;
import com.example.business.vo.order.UserOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
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

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //保存或者修改订单
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveOrUpdateOrder(UserOrderVO userOrderVO) {
        // 保存或修改订单
        UserOrderPO userOrderPO = BeanCopyUtils.copyObject(userOrderVO, UserOrderPO.class);

        //下面三行根据降序生成递增序列
     /*   List<UserOrderPO> orderByDesc = userOrderPOMapper.getOrderByDesc();
        String sortOrderNumber = orderUtils.getSortOrderNumber(orderByDesc);
        userOrderPO.setOrderId(sortOrderNumber);*/

        userOrderPO.setOrderId(orderUtils.createAutoIDByRedis(stringRedisTemplate));
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



    //根据用户名查询该用户所有订单
    @Override
    public List<UserOrderPO> listUserOrderByUsername(String username) {
        QueryWrapper<UserOrderPO> wrapper = new QueryWrapper<>();
        wrapper.eq("con_username", username);
        return userOrderPOMapper.selectList(wrapper);
    }

    //根据用户名查询该用户所有订单+分页
    @Override
    public List<UserOrderPO> listUserOrderByUsernamePage(String username, int current, int size) {
        QueryWrapper<UserOrderPO> wrapper = new QueryWrapper<>();
        Page<UserOrderPO> page = new Page<>(current,size);
        wrapper.eq("con_username", username);
         userOrderPOMapper.selectPage(page,wrapper);
         return page.getRecords();
    }



    //根据供应商查询该用户所有订单
    @Override
    public List<UserOrderPO> listUserOrderBySupplier(String supplier) {
        QueryWrapper<UserOrderPO> wrapper = new QueryWrapper<>();
        wrapper.eq("supplier", supplier);
        return userOrderPOMapper.selectList(wrapper);
    }

    //根据供应商查询该用户所有订单+分页
    @Override
    public List<UserOrderPO> listUserOrderBySupplierPage(String supplier, int current, int size) {
        QueryWrapper<UserOrderPO> wrapper = new QueryWrapper<>();
        Page<UserOrderPO> page = new Page<>(current,size);
        wrapper.eq("supplier", supplier);
        userOrderPOMapper.selectPage(page,wrapper);
        return page.getRecords();
    }


}
