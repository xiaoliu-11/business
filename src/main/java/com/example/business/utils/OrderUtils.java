package com.example.business.utils;

import com.example.business.entity.UserOrderPO;
import com.example.business.mapper.UserOrderPOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;


@Component
public class OrderUtils {

//    @Resource
//    private UserOrderPOMapper userOrderPOMapper;



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
            orderNumber =  "DD" + str + k;
        }else {
            orderNumber =  "DD" + str + "00001";
        }
       return  orderNumber;
    }







}
