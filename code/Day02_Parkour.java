package com.njupt.test;

import java.util.Random;

public class Day02_Parkour {

    // 方法1：跳跃 —— 跨越高墙，得 10 分（参数 energy 是消耗的能量）
    static int jump(int energy) {
        System.out.println("  🦘 起跳！消耗 " + energy + " 点能量");
        // return 把"得分"交还给调用者
        return 10;
    }

    // 方法2：滑铲 —— 躲低栏，得 5 分（不需要参数）
    static int slide() {
        System.out.println("  🛹 滑铲！");

        return 5;
    }
   static int sprint() {
       System.out.println("quickly");
               return 8;
    }
    // 方法3：随机生成障碍类型（1=高墙 2=低栏 3=陷阱）
    static int randomObstacle(Random r) {
        return r.nextInt(4) + 1;
    }

    public static void main(String[] args) {
        Random r = new Random();
        int score = 0;

        System.out.println("=== 校园跑酷 · Java 版（5 关）===");

        for (int round = 1; round <= 5; round++) {
            int ob = randomObstacle(r); // 调用方法3
            System.out.println("第 " + round + " 关来了：");

            if (ob == 1) {
                score += jump(3);        // 调用方法1，把返回的 10 加进总分
            } else if (ob == 2) {
                score += slide();        // 调用方法2，把返回的 5 加进总分
            } else if (ob == 3) {
                System.out.println("  💥 踩到陷阱！扣 5 分");
                score -= 5;
            }else {
                score += sprint();
            }
            System.out.println("  当前得分：" + score);
        }

        System.out.println("🏁 最终得分：" + score);
    }
}
