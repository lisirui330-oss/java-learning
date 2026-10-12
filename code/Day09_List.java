package com.njupt.test;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// 怪物类：和 Day8 的 Block 类似，但用新名字避免和 Day8 冲突
class Monster {
   private String name;
    private int damage;
    private int need;

    Monster(String name, int damage, int need) {
        this.name = name;
        this.damage = damage;
        this.need = need;
    }

    void show() {
        System.out.println("⚠️ 出现 " + name + "（" + (need==1?"跳":"滑") + "躲，撞到扣 " + damage + " 血）");
    }
    String getName() {return name;}
    int getDamage() {return damage;}
    int getNeed(){return need;}

}
class Hero{
    private String name;
    private int hp;
    private int score;
    Hero(String name ){
        this.name = name;
        this.hp = 100;
        this.score = 0;
    }
    String getName(){return name;} // Changed from int to String
    int getHp(){return hp;}
    int getScore(){return score;}
    void addScore(int s){ score += s; }
    void hurt(int d){ hp -= d; if (hp < 0) hp = 0; }
}

public class Day09_List {
    public static void main(String[] args) {
        // 1. 造一个装 Monster 的列表（动态数组，长度能自动伸缩）
        ArrayList<Monster> mobs = new ArrayList<>();

        // 2. 往里加怪物（add，想加几个加几个）
        mobs.add(new Monster("高墙", 20,1));
        mobs.add(new Monster("低栏", 10,2));
        mobs.add(new Monster("飞鸟", 15,2));
        mobs.add(new Monster("陷阱", 25,1));

        // 3. 看列表里有多少（size，相当于数组的 length）
        System.out.println("本关共 " + mobs.size() + " 种障碍");

        // 4. 随机抽一个（nextInt(size) 保证下标不越界）
        Random rnd = new Random();

        // 5. 遍历打印所有（for-each，Day3 学过，a : list 表示依次取每个）
        System.out.println("--- 全部障碍一览 ---");
        for (Monster m : mobs) {
            System.out.println(m.getName() + " 伤害 " + m.getDamage());
        }

        // 6. 移除一个（remove，数组做不到这么轻松）
        mobs.remove(0);
        System.out.println("移除第一个后剩 " + mobs.size() + " 个");
        Scanner sc = new Scanner(System.in);
        Hero p = new Hero("xxx");
        System.out.println("欢迎来到游戏，1躲过高墙和陷阱，2滑过低栏躲过飞鸟");
       while (p.getHp() > 0) {
           Monster ob = mobs.get(rnd.nextInt(mobs.size()));
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
           if (p.getHp() <= 0) {
               System.out.println("💀 游戏结束");
           }
       }
       System.out.println("🏁 最终 分:" + p.getScore() + " 血:" + p.getHp());
    }


}
