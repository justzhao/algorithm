package com.zhaopeng.study;

/**
 * Created by zhaopeng on 2016/12/29.
 */
public enum SingletonEnum {
    INSTANCE;

     SingletonEnum(){
    System.out.println("构造11");
    }


    public void call(){
        System.out.println("单例模式。。。。。。。。");
    }
}
