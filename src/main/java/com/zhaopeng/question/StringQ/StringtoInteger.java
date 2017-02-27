package com.zhaopeng.question.StringQ;

/**
 * Created by zhaopeng on 2017/2/27.
 */
public class StringtoInteger {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;
        str = str.trim();
        char f = str.charAt(0);
        int flag = 1, index = 0;
        long sum = 0;
        if (f == '+') {
            flag = 1;
            index++;
        } else if (f == '-') {
            flag = -1;
            index++;
        }


        for (int i = index; i < str.length(); i++) {
            char c=str.charAt(i);
            if (!Character.isDigit(c))
                return (int) sum * flag;
            sum = sum * 10 + c- '0';
            if (flag == 1 && sum > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (flag == -1 && (-1) * sum < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }

        return (int) sum * flag;
}

    public static void main(String args[]) {

        StringtoInteger v = new StringtoInteger();
        String s = "2147483648";
        System.out.println(v.myAtoi(s));

    }
}
