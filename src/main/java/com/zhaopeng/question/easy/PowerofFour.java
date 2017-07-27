package com.zhaopeng.question.easy;

/**
 * Created by zhaopeng on 2017/7/27.
 */

/**
 * 先判断是否为2的k次方
 * <p>
 * 然后过滤
 * <p>
 * <p>
 * 2^0 = 1, 2^1 = 10, 2^2 = 100
 * 4^0 = 1, 4^1 = 100, 4^2 = 10000 4^3=1000000
 * (每次多2个0，需要过滤掉 每次多一个0的情况，10,1000,100000
 * <p>
 * 0x55555555 =1010101010101010101010101010101
 */
public class PowerofFour {

    public boolean isPowerOfFour(int num) {
        //1.先check 是否为2的k次方
        //2.
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;

    }
}
