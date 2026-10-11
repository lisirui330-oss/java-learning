package com.njupt.test;

import java.util.Scanner;

public class Day03_Leaderboard {

    public static void main(String[] args) {
        // 1) 数组：一排"同款的盒子"，用来装多个同类数据
        int[] scores = new int[5];          // 开 5 个格子，装 5 局得分
        Scanner sc = new Scanner(System.in);

        // 2) 把每局比分读进数组
        for (int i = 0; i < scores.length; i++) {
            System.out.print("请输入第 " + (i + 1) + " 局得分：");
            scores[i] = sc.nextInt();        // scores[0] 是第一个格子
        }

        // 3) 找最高分：调用下面的 findMax 方法（Day 2 学的方法复用！）
        int max = findMax(scores);
        System.out.println("🏆 最高分：" + max);

        // 4) 算平均分：先累加，再除以局数
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        double avg = sum / (double) scores.length;   // 除以 5.0 才得小数
        System.out.println("📊 平均分：" + avg);
    }

    // 方法：找最高分（必须放在 main 外面、class 里面！）
    static int findMax(int[] scores) {
        int max = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        return max;   // return 放在循环结束后，不能在循环里！
    }
}
