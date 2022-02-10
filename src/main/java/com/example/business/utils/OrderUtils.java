package com.example.business.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class OrderUtils {

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

}
