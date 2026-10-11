package com.njupt.test;

import java.util.ArrayList;
import java.util.Random;

// 怪物类：和 Day8 的 Block 类似，但用新名字避免和 Day8 冲突
class Monster {
    String name;
    int damage;
    Monster(String n, int d) {
        name = n;
        damage = d;
    }
    void show() {
        System.out.println("⚠️ 出现 " + name + "，撞到扣 " + damage + " 血");
    }
}

public class Day09_List {
    public static void main(String[] args) {
        // 1. 造一个装 Monster 的列表（动态数组，长度能自动伸缩）
        ArrayList<Monster> mobs = new ArrayList<>();

        // 2. 往里加怪物（add，想加几个加几个）
        mobs.add(new Monster("高墙", 20));
        mobs.add(new Monster("低栏", 10));
        mobs.add(new Monster("飞鸟", 15));
        mobs.add(new Monster("陷阱", 25));

        // 3. 看列表里有多少（size，相当于数组的 length）
        System.out.println("本关共 " + mobs.size() + " 种障碍");

        // 4. 随机抽一个（nextInt(size) 保证下标不越界）
        Random rnd = new Random();
        Monster ob = mobs.get(rnd.nextInt(mobs.size()));
        System.out.print("本回合抽到：");
        ob.show();

        // 5. 遍历打印所有（for-each，Day3 学过，a : list 表示依次取每个）
        System.out.println("--- 全部障碍一览 ---");
        for (Monster m : mobs) {
            System.out.println(m.name + " 伤害 " + m.damage);
        }

        // 6. 移除一个（remove，数组做不到这么轻松）
        mobs.remove(0);
        System.out.println("移除第一个后剩 " + mobs.size() + " 个");
    }
}
