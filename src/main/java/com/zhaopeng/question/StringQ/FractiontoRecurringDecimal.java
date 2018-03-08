package com.zhaopeng.question.StringQ;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/fraction-to-recurring-decimal/description/
 * Created by zhaopeng on 2018/1/29.
 * 算术题：
 * 1.正负号，
 * 2. 越界，比如整数越界
 * 3. 整数
 * 4. 小数
 */
public class FractiontoRecurringDecimal {


    public static void main(String args[]){
        FractiontoRecurringDecimal o=new FractiontoRecurringDecimal();

        int a=2;int b=3;
        System.out.println(o.fractionToDecimal(a,b));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        sb.append((numerator > 0 ^ denominator > 0) ? "-" : "");
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        sb.append(num / den);
        num = num % den;
        if (num == 0) {
            return sb.toString();
        }
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(num,sb.length());
        while (num != 0) {
            num = num * 10;
            sb.append(num/den);
            num=num%den;
            if(map.containsKey(num)){
                int pos=map.get(num);
                sb.insert(pos,"(");
                sb.append(")");
                break;
            }else {
                map.put(num,sb.length());
            }
        }
        return sb.toString();
    }
}
