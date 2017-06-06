package com.zhaopeng.study;

/**
 * Created by zhaopeng on 2017/6/4.
 */
public class AutoBox {

    public static void main(String args[]) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Integer h=320;
        int i=320;


        System.out.println(c==d);  //true
        System.out.println(e==f); // false
        System.out.println(c==(a+b)); //true
        System.out.println(c.equals(a+b)); //true
        System.out.println(g==(a+b)); //true
        System.out.println(g.equals(a+b)); // false
        System.out.println(e==(a+h)); // true;
        System.out.println(h==i); //true
    }
}
