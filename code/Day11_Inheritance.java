package com.njupt.test;

import java.util.ArrayList;
import java.util.Random;

// ===== 父类：所有游戏角色的共同特征 =====
class GameUnit {
    String name;   // 名字（子类直接继承，不用再写一遍）
    int hp;        // 血量（子类直接继承，不用再写一遍）

    GameUnit(String name, int hp) {   // 父类构造
        this.name = name;
        this.hp = hp;
    }

    void show() {   // 共同动作：报幕（子类会各自重写）
        System.out.println(name + " 血量 " + hp);
    }
}

// ===== 子类 HeroUnit 继承 GameUnit =====
class HeroUnit extends GameUnit {
    int score;   // 英雄多一个分数（父类里没有，自己加）

    HeroUnit(String name) {
        super(name, 100);   // super = 调用父类构造，把名字和 100 血交给父类去存
        this.score = 0;
    }

    void show() {   // 重写：把从父类继承来的那版 show 覆盖掉，加上分数信息
        System.out.println("🛹 " + name + " 血量 " + hp + " 分 " + score);
    }

    void addScore(int s) { score += s; }
    void hurt(int d) { hp -= d; if (hp < 0) hp = 0; }
    int getHp() { return hp; }
    int getScore() { return score; }
    String getName() { return name; }
}

// ===== 子类 MonsterUnit 继承 GameUnit =====
class MonsterUnit extends GameUnit {
    int damage;
    int need;

    MonsterUnit(String name, int hp, int damage, int need) {
        super(name, hp);   // 调用父类构造存 name 和 hp
        this.damage = damage;
        this.need = need;
    }

    void show() {   // 重写：怪物报幕显示扣血信息
        System.out.println("⚠️ " + name + " 血量 " + hp + " 撞到扣 " + damage);
    }

    int getDamage() { return damage; }
    int getNeed() { return need; }
}

public class Day11_Inheritance {
    public static void main(String[] args) {
        // 1. 继承演示：子类没写 name/hp，但能直接用（从父类继承来的）
        HeroUnit hero = new HeroUnit("小明");
        MonsterUnit mob = new MonsterUnit("高墙", 50, 20, 1);
        System.out.println("--- 继承：子类白拿了父类的 name/hp ---");
        hero.show();
        mob.show();

        // 2. 重写演示：同一个 show，英雄和怪物表现不同（上面已看到）

        // 3. 多态演示：父类当筐，不同子类都能装
        ArrayList<GameUnit> units = new ArrayList<>();
        units.add(hero);   // HeroUnit 是 GameUnit 的一种，能装
        units.add(mob);    // MonsterUnit 也是 GameUnit 的一种，能装
        System.out.println("--- 多态：同一句 u.show()，各演各的 ---");
        for (GameUnit u : units) {
            u.show();   // u 到底是英雄还是怪物，电脑自动挑对应的 show
        }
    }
}
