package com.njupt.test;

import java.util.Scanner;   // Day1 学的输入
import java.util.Random;    // Day4 学的随机

// 注意：类名改成 Runner / Block，因为包里已经有 Player / Obstacle 了
// 规则：同一个包（com.njupt.test）里，类名必须唯一，不能重名！

// ===== 跑者类（就是玩家）=====
class Runner {
    String name;
    int hp;
    int score;
    Runner(String n) {      // 构造方法：new 时给名字，血默认 100
        name = n;
        hp = 100;
    }
    void jump()  { System.out.println(name + " 🛹 跳跃！"); }
    void slide() { System.out.println(name + " 🛼 滑行！"); }
    void dodge() {          // 躲过障碍：加分
        score += 10;
        System.out.println(name + " ✅ 躲过！+10 分，总分 " + score);
    }
    void hit(int d) {       // 被撞：扣血
        hp -= d;
        System.out.println(name + " 💥 被撞！-" + d + " 血，剩 " + hp);
    }
}

// ===== 障碍类 =====
class Block {
    String name;
    int damage;   // 撞到扣多少血
    int need;     // 躲开它需要什么操作：1=跳, 2=滑
    Block(String n, int d, int nd) {
        name = n; damage = d; need = nd;
    }
    void show() {
        System.out.println("⚠️ 前方出现 " + name + "（撞到扣 " + damage + " 血）");
    }
}

// ===== 游戏主程序 =====
public class Day08_Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        Runner p = new Runner("小明");                 // 造跑者
        Block wall = new Block("高墙", 20, 1);          // 高墙：需要跳(1)
        Block bar  = new Block("低栏", 10, 2);          // 低栏：需要滑(2)
        Block bird = new Block("飞鸟",15,2);
        System.out.println("🏃 跑酷开始！每回合 1=跳 2=滑，血没了就结束");
        while (p.hp > 0) {                            // Day6 学的 while 生存模式
            // 随机挑一个障碍（Day4 的 Random）
            int r = rnd.nextInt(3);              // 只摇一次号，存进 r
            Block ob;
            if (r == 0) { ob = wall; }
            else if (r == 1) { ob = bar; }
            else { ob = bird; }                  // r 只能是 0/1/2，必中一个
            ob.show();

            System.out.print("你的操作(1跳/2滑)：");
            int act = sc.nextInt();                   // Day1 的 Scanner 输入
            if (act == 1) { p.jump(); }
            else { p.slide(); }

            // 操作对了就躲过，错了就挨撞
            if (act == ob.need) {
                p.dodge();
            } else {
                p.hit(ob.damage);
                if (p.hp <= 0) {
                    System.out.println("💀 游戏结束！");
                    break;
                }
            }
        }
        System.out.println("🏁 " + p.name + " 最终得分：" + p.score);
    }
}
