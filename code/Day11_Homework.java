package com.njupt.test;

import java.util.ArrayList;
import java.util.Random;

// ===== 父类（骨架，已给你，不用改）=====
class Barrier {
    String name;
    int damage;

    Barrier(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    void appear() {
        System.out.println(name + " 出现了，撞到扣 " + damage + " 血");
    }
}

// ===== 子类 1：墙（TODO 你填）=====
class Wall extends Barrier {

    // 构造方法已给你：只收 name，扣血固定写死 20
    Wall(String name) {
        super(name, 20);
    }

    // 重写：墙的专属台词（同名同参，盖掉父类那版）
    @Override
    void appear() {
        System.out.println("🧱 " + name + " 挡在前面！撞到扣 " + damage + " 血");
    }
}

// ===== 子类 2：陷阱 =====
class Trap extends Barrier {

    // 构造方法：只收 name，扣血固定写死 35
    Trap(String name) {
        super(name, 35);
    }

    // 重写：陷阱的专属台词
    @Override
    void appear() {
        System.out.println("🕳️ " + name + " 打开了！掉进去扣 " + damage + " 血");
    }
}

// ===== 主方法：把障碍装进筐，随机抽一个让它出现 =====
public class Day11_Homework {
    public static void main(String[] args) {

        ArrayList<Barrier> barriers = new ArrayList<>();
        barriers.add(new Wall("校园高墙"));
        barriers.add(new Trap("下水陷阱"));

        Random rnd = new Random();

        // 摇一次存进变量 → 取出障碍 → 调 appear()（同一句，各演各的）
        int pick = rnd.nextInt(barriers.size());
        Barrier chosen = barriers.get(pick);
        chosen.appear();

        // 连抽 5 次看随机效果
        System.out.println("--- 连抽 5 次 ---");
        for (int i = 0; i < 5; i++) {
            Barrier b = barriers.get(rnd.nextInt(barriers.size()));
            b.appear();
        }
    }
}
