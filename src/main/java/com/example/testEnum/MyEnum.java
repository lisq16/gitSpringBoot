package com.example.testEnum;

/**
 * 2 * @Author: Lisq
 * 3 * @Date: 2022/10/23 18:39
 * 4
 */
public class MyEnum {

    public  enum MyEnum01 {

        RED("red1","RED1"),
        GREEN("green1","GREEN1"),
        BLUE("blue1","BLUE1");  //枚举对象必须写下第一行，否则报错
        private String info; //定义info属性(信息)
        private String desc;

        private MyEnum01(String info,String desc){ //定义有参构造
            this.info = info;
            this.desc = desc;
        }
        public String getInfo(){
            return this.info;
        }
        public String toString() {
            return this.info+","+this.desc;
        }

    }
}
