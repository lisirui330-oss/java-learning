package com.njupt.test;

public class Demo_Types {
    public static void main(String[] args) {
        // int = 整数类型
        int a = 7, b = 2;
        System.out.println("int 除法 7/2 = " + (a / b));        // 整数相除，结果只留整数
        System.out.println("double 除法 7/2.0 = " + (a / 2.0)); // 有一个是小数，结果才保留小数

        // boolean = 真/假类型
        boolean 成年 = 18 >= 18;
        System.out.println("18岁算成年吗？" + 成年);

        // char = 单个字符（用单引号）
        char 星 = '★';
        System.out.println("一个字符：" + 星);
    }
}
