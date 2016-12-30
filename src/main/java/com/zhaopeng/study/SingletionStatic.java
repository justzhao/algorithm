package com.zhaopeng.study;

import java.io.Serializable;

/**
 * Created by zhaopeng on 2016/12/29.
 */
public class SingletionStatic implements Serializable {

    public static boolean flag=false;

    private SingletionStatic(){

        if(!flag){
            flag=true;
        }else {
            throw new RuntimeException("已经被实例化了");
        }

    }
    private static class SingletionHolder {
        public static SingletionStatic instance = new SingletionStatic();
    }
    public static SingletionStatic getSingletion(){
        return SingletionHolder.instance;
    }

    // 实现此方法来保证序列化和反序列化的时候保证单例
    public Object readResolve(){
        return getSingletion();
    }
}
