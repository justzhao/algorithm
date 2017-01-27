package com.zhaopeng.question.StringQ;

/**
 * 魔数字符串由12 组成，可以按照12 来分组，
 * 这样每个分组中1 和2的个数是魔数字符串的部分
 * 限定魔数的前三个数字是122
 * <p>
 * 思路： 魔数中 每组1 和2 的个数不回超过3个。
 * <p>
 * <p>
 * ms:      1 22     11  2  1
 * groupc:  1  2     2  1  1
 *
 * 此例子发现字符串拼接的效率比StringBuilder低一个数量级别
 * Created by zhaopeng on 2017/1/27.
 */
public class MagicalString {

    public int magicalString(int n) {
        if(n<=0) return 0;
        if(n==3) return 1;

       // String ms = "122";
        StringBuilder sb=new StringBuilder("122");
        int oneC = 1;

        int groupN = 2;
        int groupC = 0;

        int last = 2;

        int len = sb.length();
        while (len < n) {

            if (groupC == 0) {
                groupN++;
                groupC = sb.charAt(groupN-1) - '0';
            }
            if (groupC + len >= n) {
                if (last == 2) {

                    oneC=oneC+n-sb.length();
                }
                break;
            }


            if (last % 2 == last) {
                last = last + 1;
            } else {
                last = last - 1;
                oneC = oneC + groupC;
            }

            while (groupC > 0) {
               // ms = ms + last;
                sb.append(last);
                groupC--;
            }
            len = sb.length();

        }

        System.out.println("ms is " + sb.toString());
        return oneC;
    }

    public static void main(String args[]) {
        MagicalString v = new MagicalString();

        System.out.println(v.magicalString(4)); //122112
    }
}
