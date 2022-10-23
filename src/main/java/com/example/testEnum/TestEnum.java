package com.example.testEnum;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 2 * @Author: Lisq
 * 3 * @Date: 2022/10/23 18:42
 * 4
 */
public class TestEnum {
    public static <T extends Enum<T>> void  test(Class<T> enumData) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method info = enumData.getMethod("getInfo");
        for (T e: enumData.getEnumConstants()) {
            String a = (String) info.invoke(e,null);
            System.out.println(a);
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        test(MyEnum.MyEnum01.class);
    }

}
