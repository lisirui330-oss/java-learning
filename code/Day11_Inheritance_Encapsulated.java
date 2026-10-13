package com.njupt.test;

import java.util.ArrayList;

// ===== 父类：字段全部 private + 只给 getter（封装版）=====
class EnGameUnit {
    private String name;   // 封起来：外面不能直接 name = xxx
    private int hp;        // 封起来：外面不能直接 hp = -999

    EnGameUnit(String name, int hp) {   // 父类构造：唯一的写入口
        this.name = name;
        this.hp = hp;
    }

    // 只读通道：子类、外面都只能靠这两个方法拿值，不能直接摸字段
    String getName() { return name; }
    int getHp() { return hp; }

    // hp 的修改权也锁在父类里：外面想扣血只能调 hurt，改不成负数
    void hurt(int d) { hp -= d; if (hp < 0) hp = 0; }

    void show() {   // 父类这版 show 用 getter 读，保证能编译、能兜底
        System.out.println(getName() + " 血量 " + getHp());
    }
}

// ===== 子类 HeroUnit 继承 EnGameUnit =====
class EnHeroUnit extends EnGameUnit {
    private int score;   // 子类自己的字段，同样 private

    EnHeroUnit(String name) {
        super(name, 100);   // 名字和 100 血交给父类去存（父类字段已封，只能走 super）
        this.score = 0;
    }

    int getScore() { return score; }
    void addScore(int s) { score += s; }

    @Override
    void show() {   // 重写：读字段一律走 getter，不再直接碰 name/hp
        System.out.println("🛹 " + getName() + " 血量 " + getHp() + " 分 " + score);
    }
}

// ===== 子类 MonsterUnit 继承 EnGameUnit =====
class EnMonsterUnit extends EnGameUnit {
    private int damage;
    private int need;

    EnMonsterUnit(String name, int hp, int damage, int need) {
        super(name, hp);   // 父类字段已封，只能走 super
        this.damage = damage;
        this.need = need;
    }

    int getDamage() { return damage; }
    int getNeed() { return need; }

    @Override
    void show() {
        System.out.println("⚠️ " + getName() + " 血量 " + getHp() + " 撞到扣 " + damage);
    }
}

public class Day11_Inheritance_Encapsulated {
    public static void main(String[] args) {
        // 1. 继承 + 封装：字段全 private，子类靠 getter 读、靠 super 写
        EnHeroUnit hero = new EnHeroUnit("小明");
        EnMonsterUnit mob = new EnMonsterUnit("高墙", 50, 20, 1);
        System.out.println("--- 继承 + 封装：字段全 private，靠 getter 读 ---");
        hero.show();
        mob.show();

        // 2. 顺手演示：血被扣成负数也兜得住（hurt 里锁了下限）
        hero.hurt(999);
        System.out.println("小明挨了 999 点伤害后：");
        hero.show();

        // 3. 多态照常工作：父类当筐，子类各自重写 show，统一调一句 u.show()
        ArrayList<EnGameUnit> units = new ArrayList<>();
        units.add(hero);
        units.add(mob);
        System.out.println("--- 多态：同一句 u.show()，各演各的 ---");
        for (EnGameUnit u : units) {
            u.show();   // u 声明类型是父类，父类有 show() 所以编译过；运行时自动挑子类版
        }
    }
}
