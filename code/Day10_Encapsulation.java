package com.njupt.test;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// 封装版怪物（类名加 Safe 前缀，避免和 Day09 的 Monster 重名）：字段藏起来，外面只能看 show() 报幕
class SafeMonster {
    private String name;     // private = 锁起来，外面碰不到
    private int damage;
    private int need;

    // 构造方法：参数名和字段名一样，用 this 指明"这是对象自己的字段"
    SafeMonster(String name, int damage, int need) {
        this.name = name;       // this.name = 这个怪物自己的名字字段
        this.damage = damage;
        this.need = need;
    }

    void show() {
        System.out.println("⚠️ 出现 " + name + "（" + (need == 1 ? "跳" : "滑") + "躲，撞到扣 " + damage + " 血）");
    }

    // 外面想读伤害/需要动作，只能调这两个只读方法，改不了
    int getDamage() { return damage; }
    int getNeed() { return need; }
}

// 封装版英雄（类名加 Safe 前缀，避免和 Day09 的 Hero 重名）：血量不能随便被改成负数
class SafeHero {
    private String name;
    private int hp;
    private int score;

    SafeHero(String name) {
        this.name = name;
        this.hp = 100;
        this.score = 0;
    }

    void addScore(int s) { score += s; }

    void hurt(int d) {
        hp -= d;
        if (hp < 0) hp = 0;     // 封装的好处：内部兜底，血永远不会变负
    }

    int getHp() { return hp; }
    int getScore() { return score; }
    String getName() { return name; }
}

public class Day10_Encapsulation {
    public static void main(String[] args) {
        ArrayList<SafeMonster> mobs = new ArrayList<>();
        mobs.add(new SafeMonster("高墙", 20, 1));
        mobs.add(new SafeMonster("低栏", 10, 2));
        mobs.add(new SafeMonster("飞鸟", 15, 2));
        mobs.add(new SafeMonster("陷阱", 25, 1));

        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        SafeHero p = new SafeHero("小明");

        System.out.println("欢迎 " + p.getName() + "，开始跑酷！");
        while (p.getHp() > 0) {
            SafeMonster ob = mobs.get(rnd.nextInt(mobs.size()));
            ob.show();
            System.out.print("你的操作(1跳/2滑)：");
            int act = sc.nextInt();
            if (act == ob.getNeed()) {
                p.addScore(10);
                System.out.println("✅ 躲过 +10");
            } else {
                p.hurt(ob.getDamage());
                System.out.println("💥 被撞 -" + ob.getDamage() + " 血，剩 " + p.getHp());
            }
        }
        System.out.println("💀 游戏结束 最终 分:" + p.getScore() + " 血:" + p.getHp());
    }
}
