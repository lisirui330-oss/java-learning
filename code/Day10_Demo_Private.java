package com.njupt.test;

// ===== 反面教材：字段敞开（不封装）=====
class LooseHero {
    String name;
    int hp;          // 敞开门：外面谁都能改
    int score;
    LooseHero(String n) { name = n; hp = 100; score = 0; }
    void show() { System.out.println(name + " 血量：" + hp + " 分：" + score); }
}

// ===== 正面教材：字段加 private 锁起来 =====
class LockedHero {
    private String name;
    private int hp;   // 锁起来：外面碰不到
    private int score;
    LockedHero(String n) { name = n; hp = 100; score = 0; }
    // 正门①：扣血，而且兜底——血永远不会变负
    void hurt(int d) {
        hp -= d;
        if (hp < 0) hp = 0;
    }
    // 正门②：加分
    void addScore(int s) { score += s; }
    // 正门③：只读，外面想看只能走这
    int getHp() { return hp; }
    int getScore() { return score; }
    String getName() { return name; }
    void show() { System.out.println(name + " 血量：" + hp + " 分：" + score); }
}

public class Day10_Demo_Private {
    public static void main(String[] args) {
        System.out.println("=== 不封装的 LooseHero（危险示范）===");
        LooseHero a = new LooseHero("小明");
        a.show();
        // 危险：字段敞开，外面随手一写游戏就崩
        a.hp = -999;
        System.out.println("有人手滑/使坏把血量写成 -999，游戏居然显示：");
        a.show();   // 血量变成 -999，怪物还没打就"负血"，逻辑全乱套

        System.out.println("\n=== 封装的 LockedHero（安全示范）===");
        LockedHero b = new LockedHero("小红");
        b.show();
        b.hurt(30);
        System.out.println("被撞 -30，走正门 hurt() 后：");
        b.show();
        // 想搞破坏？直接写 b.hp = -999 电脑根本不让编译（锁住了），这行必须注释掉：
        // b.hp = -999;   // ← 取消注释就报错：hp 在 LockedHero 中是 private 的，外面碰不到
        // 只能走正门，而且正门里有兜底规矩：
        b.hurt(999999);
        System.out.println("就算被扣 999999，血量也只会停在 0（不会变负）：");
        b.show();
    }
}
