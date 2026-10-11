package com.njupt.test;

import java.util.Scanner; // 导入“扫描仪”，用来读取键盘输入

public class Day01_HelloYou {
    public static void main(String[] args) {
        // 1) 输出：把文字打印到屏幕
        System.out.println("=== 你好，我是你的 Java 助教 ===");

        // 2) 输入：用 Scanner 从键盘读内容
        Scanner sc = new Scanner(System.in);

        System.out.print("你叫什么名字？");
        String name = sc.next();        // String = 文本类型

        System.out.print("你今年几岁？");
        int age = sc.nextInt();          // int = 整数类型

        System.out.print("你每天能学几分钟 Java？");
        int minutes = sc.nextInt();      // int = 整数类型

        // 3) 变量 + 拼接：用 + 把文字和数字连起来
        System.out.println("你好，" + name + "！你 " + age + " 岁，每天能学 " + minutes + " 分钟。");

        // 4) if 判断：根据年龄给不同建议
        if (age < 20) {
            System.out.println("大一正是起步黄金期，你已经领先很多人了 👍");
        } else if (age < 25) {
            System.out.println("节奏抓紧一点，完全来得及 💪");
        } else {
            System.out.println("什么时候开始都不晚，坚持最重要 🔥");
        }

        // 5) for 循环：重复做一件事（这里模拟 7 天打卡）
        System.out.println("下面给你生成 7 天学习打卡计划：");
        for (int day = 1; day <= 2; day++) {
            System.out.println("第 " + day + " 天：学 " + minutes + " 分钟，累计 " + (minutes * day) + " 分钟");
        }

        sc.close(); // 用完关闭，好习惯
    }
}
