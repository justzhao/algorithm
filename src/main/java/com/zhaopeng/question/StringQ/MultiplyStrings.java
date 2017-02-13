package com.zhaopeng.question.StringQ;

/**
 * 两个字符串数字相乘以
 * 可以看成两个数组num1[] ,num2[]相乘 得到的结果为 res[]
 * 从左向右 索引从0开始，对于num1[i] * num2[j]
 * 得到的结果体现在res[i+j] 和res[i+j+1] 上，其中res[i+j] 是进位，res[i+j+1] 是进位后的结果
 * <p>
 * <p>
 * Created by zhaopeng on 2017/2/13.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {

        char n1[] = num1.toCharArray();
        char n2[] = num2.toCharArray();

        int res[] = new int[n1.length + n2.length];

        for (int i = n1.length - 1; i >= 0; i--) {
            for (int j = n2.length - 1; j >= 0; j--) {
                int a = n1[i] - '0';
                int b = n2[j] - '0';
                int mul = a * b;
                int result=mul+res[i+j+1];
                int remainder = result % 10;
                int sum = result / 10;
                res[i + j] += sum;
                res[i + j + 1] =remainder ;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (!(builder.length() == 0 && res[i] == 0)) {
                builder.append(res[i]);
            }
        }
        if(builder.length()==0) return "0";

        return builder.toString();
    }

    public  static  void main(String args[]){
        MultiplyStrings v=new MultiplyStrings();
        String s1="123";
        String s2="456";
        System.out.println(v.multiply(s1,s2));
    }
}
