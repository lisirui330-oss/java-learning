package com.njupt.test;

import java.util.Random;  // 用 Random 要导入

// 障碍类（模具）
class Obstacle {
    String name;    // 障碍名
    int damage;     // 撞到扣多少血

    // ★ 构造方法：名字必须和类名 Obstacle 一模一样，没有返回值（连 void 都不写）
    //   new 的时候 Java 会自动调用它，把传进来的 n、d 赋给属性
    Obstacle(String n, int d) {
        name = n;      // 把传进来的名字，存进这块月饼的 name
        damage = d;    // 把传进来的扣血，存进这块月饼的 damage
    }

    // 出现：打印自己这块障碍的信息
    void appear() {
        System.out.println("⚠️ 前方出现 " + name + "，撞到扣 " + damage + " 血");
    }
}

public class Day07_Homework {
    public static void main(String[] args) {
        // 用构造方法：造月饼的同时直接把名字和扣血"灌"进去，一行搞定！
        Obstacle o1 = new Obstacle("高墙", 20);
        Obstacle o2 = new Obstacle("低栏", 10);

        // 随机让其中一个出现（复习 Day4 的 Random）
        Random random = new Random();
        int r = random.nextInt(2);   // 0 或 1
        if (r == 0) {
            o1.appear();
        } else {
            o2.appear();
        }
    }
}
