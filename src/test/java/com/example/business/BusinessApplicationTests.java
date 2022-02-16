package com.example.business;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.business.entity.UserInfoPO;
import com.example.business.entity.UserOrderPO;
import com.example.business.mapper.UserInfoMapper;
import com.example.business.mapper.UserOrderPOMapper;
import com.example.business.service.UserInfoService;
import com.example.business.service.UserOrderPOService;
import com.example.business.utils.OrderUtils;
import com.example.business.utils.RedisUtil;
import com.example.business.vo.user.UserRoleVO;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class BusinessApplicationTests {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserOrderPOMapper userOrderPOMapper;

    @Autowired
    private UserOrderPOService userOrderPOService;

    @Resource
    private RedisUtil redisUtil;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

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
        System.out.println("deleteById" + deleteById);
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


    @Test
    public void testRedis() {
        redisUtil.setValue("ss1", "hahahah");
    }


    //降序输出订单号
    @Test
    public void testOrderByDesc() {

        System.out.println(userOrderPOMapper.getOrderByDesc().get(0).getOrderId().substring(10));
    }


    //redis自增输出订单号
    @Test
    public void testRedisId() {
        System.out.println(createAutoIDByRedis());
    }


    public String createAutoIDByRedis( ) {
        //时间戳 后面拼接流水号
        String datetime = new SimpleDateFormat("yyyyMMdd").format(new Date());
        //这里是 Redis key的前缀，如: sys:表名:日期  如果不需要去掉表名也可以
        String key = MessageFormat.format("{0}:{1}",  "user_order",datetime);
        //查询 key 是否存在， 不存在返回 1 ，存在的话则自增加1
        Long autoID = stringRedisTemplate.opsForValue().increment(key, 1);
        // 设置key过期时间, 保证每天的流水号从1开始
        if(autoID==1){
            stringRedisTemplate.expire(key, 86400, TimeUnit.SECONDS);
        }
        //这里是 6 位id，如果位数不够可以自行修改 ，下面的意思是 得到上面 key 的 值，位数为6 ，不够的话在左边补 0 ，比如  110 会变成  000110
        String value = StringUtils.leftPad(String.valueOf(autoID), 6, "0");
        //然后把 时间戳和优化后的 ID 拼接
        String code = MessageFormat.format("{0}{1}{2}", "DD", datetime,value);
        return code;
    }


    @Test
    public void testgetOrderByUsername(){
        System.out.println(userOrderPOService.listUserOrderByUsername("货主1号"));
    }

}
