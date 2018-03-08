package com.zhaopeng.question.StringQ;

/**
 * https://leetcode.com/problems/zigzag-conversion/description/
 * Created by zhaopeng on 2018/2/21.
 */
public class ZigZagConversion {


    public String convert(String s, int numRows) {

        if (numRows <= 1) {
            return s;
        }

        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuffer();
        }
        for (int i = 0; i < len; i++) {
            //V字一个轮回
            int index = i % (2 * numRows - 2);
            index = index < numRows ? index : (2 * numRows - 2 - index);
            sb[index].append(c[i]);
        }

        for (int i = 1; i < numRows; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}
