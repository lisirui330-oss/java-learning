package com.njupt.test;

import java.util.Scanner;
import java.util.Random;

public class Day04_Game {

    // ===== 下面 4 个"技能"都在 main 外面、class 里面（Day 2 方法）=====

    // 技能1：跳跃 —— 得 10 分（int 是返回类型，return 把分交回）
    static int jump(int energy) {
        System.out.println("  🛹 跳跃！");
        return 10;
    }

    // 技能2：滑铲 —— 得 5 分
    static int slide() {
        System.out.println("  🤸 滑铲！");
        return 5;
    }

    // 技能3：陷阱 —— 扣 5 分
    static int trap() {
        System.out.println("  💥 陷阱！");
        return -5;
    }

    // 技能4：随机出障碍（1=高墙 2=低栏 3=陷阱）
    static int randomObstacle(Random r) {
        return r.nextInt(3) + 1;   // 返回 1~3
    }

    // 技能5：找最高分（Day 3 数组 + 方法复用）
    static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;   // return 在循环外面！
    }

    public static void main(String[] args) {
        System.out.println("想玩几局游戏？");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Random r = new Random();


        int[] scores = new int[n];   // n 个格子存 n 局得分（Day 3 数组）

        System.out.println("🎮 校园跑酷" + n + "局挑战开始！");

        // 跑 5 局（Day 1 for 循环）
        for (int round = 1; round <= n; round++) {
            System.out.println("--- 第 " + round + " 局 ---");
            int ob = randomObstacle(r);
            int roundScore;

            if (ob == 1) {
                roundScore = jump(3);          // 用 = 接住返回的 10
            } else if (ob == 2) {
                roundScore = slide();          // 接住 5
            } else {
                roundScore = trap();           // 接住 -5
            }

            scores[round - 1] = roundScore;    // 第 round 局 → 存下标 round-1（从0！）
            System.out.println("   本局得分：" + roundScore);
        }

        // 统计：最高分 + 总分 + 平均
        int max = findMax(scores);
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        double avg = sum / (double) scores.length;   // 除以 n.0 才得小数

        // 排行榜（再遍历一次数组）
        System.out.println("🏆 排行榜：");
        for (int i = 0; i < scores.length; i++) {
            System.out.println("  第 " + (i + 1) + " 局：" + scores[i] + " 分");
        }
        System.out.println("🏆 最高单局：" + max + " 分");
        System.out.println("📊 平均：" + avg + " 分");
    }
}
