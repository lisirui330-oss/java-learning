package com.njupt.test;

import java.util.Scanner;
import java.util.Random;

public class Day06_Game {

    // ===== 3 个"技能"（都在 main 外面、class 里面，Day 2 方法）=====
    static int jump() {
        System.out.println("  🛹 跳跃成功！+10");
        return 10;
    }

    static int slide() {
        System.out.println("  🤸 滑铲成功！+5");
        return 5;
    }

    static int crash() {
        System.out.println("  💥 撞上了！-5");
        return -5;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int hp = 100;                  // 🆕 生命值（几条命）
        int round = 0;
        int[] scores = new int[100]; // 最多记录 100 局（先开大点）
        int count = 0;               // 🆕 实际玩了几局

        System.out.println("🎮 校园跑酷（生存版）开始！");
        System.out.println("   你有 3 条命 ❤️❤️❤️，撞一次少一条，命没了就结束");

        // 🆕 while 循环：括号里条件为真就一直重复，不用预先知道局数
        while (hp > 0) {
            round++;
            int ob = r.nextInt(2) + 1;   // 1=高墙 2=低栏

            System.out.println("--- 第 " + round + " 局（命：" + hp + "）---");
            if (ob == 1) {
                System.out.println("  ⛰️ 前方高墙！(输入1跳跃)");
            } else {
                System.out.println("  🚧 前方低栏！(输入2滑铲)");
            }

            System.out.print("你的操作：");
            int act = sc.nextInt();

            int roundScore;
            if (ob == 1 && act == 1) {
                roundScore = jump();
            } else if (ob == 2 && act == 2) {
                roundScore = slide();
            } else {
                roundScore = crash();
                hp -= 20;                     // 🆕 撞一条命
                System.out.println("  ❤️ 剩余hp：" + hp);
            }

            scores[count] = roundScore;   // 🆕 用 count 当下标存
            count++;                      // 玩了一局，计数 +1
        }

        // 统计（用 count 当实际局数，而不是 scores.length）
        int max = scores[0];
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += scores[i];
            if (scores[i] > max) max = scores[i];
        }
        double avg = sum / (double) count;

        System.out.println("💀 游戏结束！共撑过 " + round + " 局");
        System.out.println("🏆 最高单局：" + max + " 分");
        System.out.println("📊 平均：" + avg + " 分");
    }
}
