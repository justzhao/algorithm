package com.zhaopeng.study;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by zhaopeng on 2016/12/29.
 */
public class SingletionClass {
    private static SingletionClass ourInstance = new SingletionClass();

    public static SingletionClass getInstance() {
        return ourInstance;
    }

    private SingletionClass() {
    }

    public static void main(String args[]) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
   /* SingletonEnum e1 = SingletonEnum.INSTANCE;

        SingletonEnum e2 = SingletonEnum.INSTANCE;

        System.out.println(e1 == e2);
        SingletonEnum.INSTANCE.call();

        Class<SingletonEnum> classType = SingletonEnum.class;
        Constructor<SingletonEnum> c = (Constructor<SingletonEnum>) classType.getDeclaredConstructor();

        c.setAccessible(true);
        SingletonEnum e3= (SingletonEnum)c.newInstance();*/

        SingletionStatic e1 = SingletionStatic.getSingletion();
        Class<SingletionStatic> classType = SingletionStatic.class;
        Constructor<SingletionStatic> c = (Constructor<SingletionStatic>) classType.getDeclaredConstructor();

        c.setAccessible(true);
        SingletionStatic e3 = (SingletionStatic) c.newInstance();

        System.out.println(e1==e3);


    }
}
