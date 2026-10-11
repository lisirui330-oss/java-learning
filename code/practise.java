package com.njupt.test;

import java.util.Random;
import java.util.Scanner;

class Wangjia {
    String name;
    int hp;
    int score;

    Wangjia(String n) {
        name = n;
        hp = 100;
        score = 0;
    }

    void jump() {
        System.out.println(name + " 🛹 跳跃成功！+10");
    }

    void slide() {
        System.out.println(name + " 🐿 滑行成功！+5");
    }

    void hit(int d) {
        hp -= d;
        System.out.println(name + " 💥 被撞！-" + d + " 血，剩 " + hp);
    }

    void dodge() {
        System.out.println(name + " ✅ 躲过障碍！");
        score += 10;
    }
}

class Zhangai {
    String name;
    int need;
    int damage;

    Zhangai(String n, int nd, int d) {
        name = n;
        need = nd;
        damage = d;
    }

    void show() {
        System.out.println("⚠️ 前方出现 " + name + "（撞到扣 " + damage + " 血）");
    }
}

public class practise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        Wangjia p = new Wangjia("小明");
        Zhangai gao = new Zhangai("高栏", 1, 10);
        Zhangai ai = new Zhangai("矮杆", 2, 5);
        System.out.println("欢迎来到游戏！1跳过高杆，2滑过低杆，血量扣完游戏结束");
        while (p.hp > 0) {
            Zhangai ob;
            if (rnd.nextInt(2) == 0) ob = gao; else ob = ai;
            ob.show();
            System.out.println("请选择动作：1跳过高杆，2滑过低杆");
            int act = sc.nextInt();
            if (act == 1) { p.jump(); } else if (act == 2) { p.slide(); }
            if (act == ob.need) { p.dodge(); }
            else { p.hit(ob.damage); }
            if (p.hp <= 0) {
                System.out.println("💀 游戏结束！你的得分" + p.score);
                break;
            }
        }
    }
}
