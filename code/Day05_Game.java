package com.njupt.test;

import java.util.Scanner;
import java.util.Random;

public class Day05_Game {

    // ===== 3 个"技能"（都在 main 外面、class 里面，Day 2 方法）=====
    static int jump() {
        System.out.println("  🛹 跳跃成功！+10");
        return 10;
    }

    static int slide() {
        System.out.println("  🤸 滑铲成功！+5");
        return 5;
    }
    static int duobi() {
        System.out.println("  🐶 躲避成功！+6");
        return 6;
    }


    static int crash() {
        System.out.println("  💥 撞上了！-5");
        return -5;
    }

    // 找最高分（Day 3 数组 + 方法复用）
    static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;   // return 在循环外面！
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        System.out.print("想玩几局？");
        int n = sc.nextInt();              // n 可以是变量！Day 4 学的

        int[] scores = new int[n];         // Day 3 数组，大小用 n
        int hits = 0;                      // 记录成功操作次数

        System.out.println("🎮 校园跑酷（手动版）开始！");
        System.out.println("   规则：高墙⛰️→输入 1 跳跃；低栏🚧→输入 2 滑铲");

        for (int round = 1; round <= n; round++) {   // Day 1 for 循环
            int ob = r.nextInt(3) + 1;               // 随机出 1(高墙) 2(低栏) 3(陷阱)

            System.out.println("--- 第 " + round + " 局 ---");
            if (ob == 1) {
                System.out.println("  ⛰️ 前方高墙！(输入1跳跃)");
            } else if (ob == 2) {
                System.out.println("  🚧 前方低栏！(输入2滑铲)");
            } else {
                    System.out.println("前方陷阱（输入3躲避）");
            }


            System.out.print("你的操作：");
            int act = sc.nextInt();                  // Day 1 输入玩家选择

            int roundScore;
            // 🆕 逻辑与 && ：两个条件都成立才进这个分支
            if (ob == 1 && act == 1) {
                roundScore = jump();
                hits++;
            } else if (ob == 2 && act == 2) {
                roundScore = slide();
                hits++;
            } else if (ob == 3 && act == 3) { roundScore = duobi(); hits++; }
            else {
                roundScore = crash();                // 操作错了就撞
            }

            scores[round - 1] = roundScore;          // Day 3 下标从 0
            System.out.println("   本局得分：" + roundScore);
        }

        // 统计
        int max = findMax(scores);
        int sum = 0;
        // 🆕 增强 for 循环：把数组里每个数依次取出来，名字叫 s
        for (int s : scores) {
            sum += s;
        }
        double avg = sum / (double) scores.length;

        System.out.println("🏆 排行榜：");
        for (int i = 0; i < scores.length; i++) {
            System.out.println("  第 " + (i + 1) + " 局：" + scores[i] + " 分");
        }
        System.out.println("🏆 最高单局：" + max + " 分");
        System.out.println("🎯 成功操作：" + hits + " / " + n + " 次");
        System.out.println("📊 平均：" + avg + " 分");
    }
}
