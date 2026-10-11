package com.njupt.test;

// ===== 类（class）= 模具 =====
// 定义"玩家"长什么样、能干什么。本身不占任何数据，只是个"模板"
class Player {
    // 属性（成员变量）：每个玩家对象都有自己独立的一份
    String name;   // 名字（文字类型）
    int hp;        // 血量（整数类型）
    int score;     // 分数（整数类型）

    // 方法（行为）：玩家能做的动作
    // 【没有 static】→ 这个方法属于"具体的某块月饼（对象）"，能直接碰这块月饼自己的 name/hp/score
    // 【void】→ 这个方法"不返回结果"。因为分数就存在这块月饼自己身上（下面 score+=10 自己改自己），不用往外传
    void jump() {
        System.out.println(name + " 🛹 跳跃成功！+10");  // 打印，name 是这块月饼自己的名字
        score += 10;   // 给"这块月饼自己的"分数 +10（score 是它自己的属性）
    }

    // int damage：调用时从外面传进来的"伤害值"，比如 hit(20) 就是 damage=20
    void hit(int damage) {
        hp -= damage;   // 这块月饼自己的血量 减去 伤害
        System.out.println(name + " 💥 被撞！-" + damage + " 血，剩 " + hp);
    }
}

// ===== 启动类：程序从这里的 main 开始跑 =====
public class Day07_Class {
    // main 是固定入口写法，先背下来：【public static void main(String[] args)】
    // 它必须写 static，因为程序一启动、还没造任何对象时，就要能直接跑起来
    public static void main(String[] args) {
        // new Player() = 用模具压出一块真月饼（真正在内存里造出对象）
        // 左边 "Player p1 =" 是声明：p1 是一个 Player 类型的"便签/遥控器（引用）"，指向那块月饼
        Player p1 = new Player();
        p1.name = "小明";   // 通过便签 p1 找到那块月饼，给它写名字
        p1.hp = 100;        // 写血量
        p1.score = 0;       // 写分数

        Player p2 = new Player();   // 同一套模具再压一块（小红）
        p2.name = "小红";
        p2.hp = 100;
        p2.score = 0;

        p1.jump();    // 让"小明这块月饼"跳一下（它自己 score 变 10）
        p1.hit(20);   // 让"小明"被撞，伤害 20（它自己 hp 变 80）
        p2.jump();    // 让"小红"跳一下

        // 打印两块月饼各自的数据，证明它们互不影响
        System.out.println("🏁 " + p1.name + " 总分：" + p1.score + "，血量：" + p1.hp);
        System.out.println("🏁 " + p2.name + " 总分：" + p2.score + "，血量：" + p2.hp);
    }
}
