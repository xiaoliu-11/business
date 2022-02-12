package com.example.business.utils;

import com.example.business.entity.UserOrderPO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


@Component
public class OrderUtils {

//    @Resource
//    private UserOrderPOMapper userOrderPOMapper;

  /*  @Autowired
    private StringRedisTemplate stringRedisTemplate;*/

    //订单号
    String orderNumber = "";

    /**
     * 生成随机流水号：DD当前年月日+五位随机数
     *
     * @return
     */
    public static String getRandomOrderNumber() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        String str = simpleDateFormat.format(date);

        Random random = new Random();
        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数

        return "DD" + str + rannum;
    }


    /**
     * 生成有序流水号：DD当前年月日+五位有序数
     *
     * @return
     */
    public String getSortOrderNumber(List<UserOrderPO> userOrderPOS) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        String str = simpleDateFormat.format(date);
        //获得数据库中订单的数据（降序排列的）
//        List<UserOrderPO> userOrderPOS = userOrderPOMapper.getOrderByDesc();
        if (userOrderPOS.size() > 0) {
            // 定义补 0 位数
            DecimalFormat decimalFormat = new DecimalFormat("00000");
            String n = userOrderPOS.get(0).getOrderId().substring(10);
            int i = Integer.parseInt(n) + 1;
            String k = decimalFormat.format(i);
            orderNumber = "DD" + str + k;
        } else {
            orderNumber = "DD" + str + "00001";
        }
        return orderNumber;
    }


    public String createAutoIDByRedis(StringRedisTemplate stringRedisTemplate ) {
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


}
