package com.example.testEnum;

/**
 * 2 * @Author: Lisq
 * 3 * @Date: 2022/10/23 18:39
 * 4
 */
public class MyEnum {

    public  enum MyEnum01 {

        RED("Red1"),
        GREEN("Green1"),
        BLUE("Blue");  //枚举对象必须写下第一行，否则报错
        private String info; //定义info属性(信息)

        private MyEnum01(String info){ //定义有参构造
            this.info = info;
        }
        public String getInfo(){
            return this.info;
        }
        public String toString() {
            return this.info;
        }

    }
}
