package com.njupt.test;

import java.util.ArrayList;

// ================================================================
// Day11 补课实验：继承 / super / 重写 / 多态
// 这个文件不用输入任何东西，直接 Run，把输出从上到下读一遍就行。
// 类名都带 Lab 前缀，和你项目里已有的 GameUnit/HeroUnit 不重复。
// ================================================================

// ===== 父类：放"所有角色都有"的东西（名字、血量、报幕）=====
class LabUnit {
    String name;   // 父类字段
    int hp;

    LabUnit(String name, int hp) {
        System.out.println("   > 父类 LabUnit 的构造方法在跑：" + name);
        this.name = name;
        this.hp = hp;
    }

    void show() {  // 父类版报幕（兜底版）
        System.out.println("   > 父类版 show 在跑：" + name + " 血量 " + hp);
    }
}

// ===== 子类：英雄。extends 的意思 = "英雄是一种游戏单位" =====
class LabHero extends LabUnit {
    int score;   // 英雄多出来的字段，父类里没有

    LabHero(String name) {
        super(name, 100);   // 第一行：把 name 和 100 交给父类构造去存
        System.out.println("   > 子类 LabHero 的构造方法在跑：" + name);
        this.score = 0;
    }

    @Override
    void show() {   // 重写：同名同参数，把父类那版盖掉
        System.out.println("   > 子类版(英雄) show 在跑：🛹 " + name + " 血量 " + hp + " 分 " + score);
    }

    void addScore(int s) {          // 重载①：一个参数
        score += s;
    }

    void addScore(int s, int bonus) {   // 重载②：两个参数，方法名一样
        score += s + bonus;
    }
}

// ===== 子类：怪物 =====
class LabMonster extends LabUnit {
    int damage;

    LabMonster(String name, int hp, int damage) {
        super(name, hp);
        this.damage = damage;
    }

    @Override
    void show() {
        System.out.println("   > 子类版(怪物) show 在跑：⚠️ " + name + " 血量 " + hp + " 撞到扣 " + damage);
    }
}

// ===== 子类：故意不重写 show()，用来看"父类那版还在不在" =====
class LabNoOverride extends LabUnit {
    LabNoOverride(String name, int hp) {
        super(name, hp);
    }
}

public class Day11_Lab {
    public static void main(String[] args) {

        System.out.println("【实验1】new 子类对象，看两个构造方法谁先跑");
        LabHero hero = new LabHero("小明");
        System.out.println("   看上面：父类构造先跑，子类构造后跑。");
        System.out.println("   再读一次数据：hero.name = " + hero.name + "，hero.hp = " + hero.hp);
        System.out.println("   LabHero 类里根本没写过 name 和 hp，但它们确实在 → 这就是继承。");
        System.out.println();

        System.out.println("【实验2】调 show()：子类重写了，跑的就是子类那版");
        hero.show();
        System.out.println();

        System.out.println("【实验3】子类没重写 show()，跑的是父类那版（父类那版不是废代码）");
        LabNoOverride stone = new LabNoOverride("石头", 30);
        stone.show();
        System.out.println();

        System.out.println("【实验4】多态：一个筐装父类类型，几个子类都能进去，统一调一句 u.show()");
        ArrayList<LabUnit> units = new ArrayList<>();
        units.add(hero);
        units.add(new LabMonster("高墙", 50, 20));
        units.add(stone);
        for (LabUnit u : units) {
            u.show();   // 同一句代码，各跑各的版本
        }
        System.out.println();

        System.out.println("【实验5】父类类型的变量，装的是子类对象");
        LabUnit u2 = new LabHero("小刚");
        u2.show();   // 编译时只查 LabUnit 有没有 show()；运行时跑子类版
        // u2.addScore(10);   // ← 这行编译报错：LabUnit 类里没有 addScore 方法
        System.out.println("   上面注释掉的 u2.addScore(10) 就是重点：父类类型只能调用父类里写过的方法。");
        System.out.println();

        System.out.println("【实验6】重载 = 同一个类里，方法名相同、参数不同（和重写对比着记）");
        LabHero h2 = new LabHero("小美");
        h2.addScore(10);        // 一个参数
        h2.addScore(10, 5);     // 两个参数
        h2.show();
        System.out.println("   重写：子类和父类之间，同名 + 同参数；重载：同一个类里，同名 + 不同参数。");
    }
}
