package com.example.business.utils;

import java.util.Random;

/**
 * @author: 刘树国
 * @create: 2022-02-10
 */

public class SaltUtils {
    public static String getSalt(int n) {
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnoprstuvwxyz0123456789!@$#%^".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char aChar = chars[new Random().nextInt(chars.length)];
            sb.append(aChar);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String salt = getSalt(4);
        System.out.println(salt);
    }
}
