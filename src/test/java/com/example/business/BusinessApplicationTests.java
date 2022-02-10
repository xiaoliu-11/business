package com.example.business;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.business.entity.UserInfoPO;
import com.example.business.entity.UserOrderPO;
import com.example.business.mapper.UserInfoMapper;
import com.example.business.mapper.UserOrderPOMapper;
import com.example.business.service.UserInfoService;
import com.example.business.utils.OrderUtils;
import com.example.business.vo.user.UserRoleVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@SpringBootTest
class BusinessApplicationTests {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserOrderPOMapper userOrderPOMapper;

    @Autowired
    private UserInfoService userInfoService;

    //查询所有数据
    @Test
    void userInfoPOlist() {
        List<UserInfoPO> userInfoPO = userInfoMapper.selectList(null);
        System.out.println(userInfoPO);
    }


    //查询所有数据
    @Test
    void userOrderPOlist() {
        List<UserOrderPO> userOrderPO = userOrderPOMapper.selectList(null);
        System.out.println(userOrderPO);
    }


    //添加
    @Test
    public void saveUserInfo() {
        UserInfoPO userInfoPO = new UserInfoPO();
        userInfoPO.setUsername("货主3号");
        userInfoPO.setPassword("123456");
        int insert = userInfoMapper.insert(userInfoPO);
        System.out.println("insert" + insert);
    }


    //添加
    @Test
    public void saveUserOrder() {
        UserOrderPO userOrderPO = new UserOrderPO();
        userOrderPO.setOrderId("DD2022020800003");
        userOrderPO.setConUsername("货主3号");
        userOrderPO.setSupplier("中国某某有限公司");
        userOrderPO.setMoney(new BigDecimal("500"));
        userOrderPO.setStartPlace("四川省成都市");
        userOrderPO.setDestination("四川省广元市");
        userOrderPO.setIsDeleted(0);
        int insert1 = userOrderPOMapper.insert(userOrderPO);
        System.out.println("insert1" + insert1);
    }


    //分页查询
    @Test
    public void testPage() {
        //1.创建page对象
        //传入两个参数：当前页，每页数量
        Page<UserInfoPO> page = new Page<>(1, 2);
        //调用mp的分页查询方法
        //把分页数据封装到page对象里面。
        userInfoMapper.selectPage(page, null);

        //通过page获得数据
        System.out.println(page.getCurrent());//当前页
        System.out.println(page.getRecords());//每页数据list集合
        System.out.println(page.getTotal());
        System.out.println(page.getSize());//每页显示的记录数
        System.out.println(page.getPages());//总页数
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }


    //删除操作

    @Test
    public void deleteUserOrder() {
        int deleteById = userOrderPOMapper.deleteById(3);
        System.out.println("deleteById"+deleteById);
    }


    //测试订单号的输出
    @Test
    public void testOrderNumber() {
        System.out.println(OrderUtils.getRandomOrderNumber());
    }


    //测试条件查询
    @Test
    public void testUserInfo() {
        UserInfoPO userinfo = userInfoMapper.selectUserById(1);
        System.out.println(userinfo);
    }



    @Test
    public void selectUserByUsernameTest() {
        UserInfoPO userinfo = userInfoMapper.selectUserByUsername("lsglsg");
        System.out.println(userinfo);
    }
}
