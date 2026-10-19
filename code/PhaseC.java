package com.njupt.test;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Playerc {
    private String name;
    private int hp;
    private int score;
    private int MaxHp;
    Playerc(String name) {
        this.name = name;
        this.MaxHp = 800;
        this.hp = 800;
        this.score = 0;
    }
    String GetName(){ return this.name; }
    int Gethp(){ return this.hp; }
    int Getscore(){ return this.score; }
    int GetMaxHp(){ return this.MaxHp; }
    void gethurt(int damage){
        hp -= damage;
        if(hp < 0){hp = 0;}
        if(hp > MaxHp){hp = MaxHp;}
    }
    void heal(int amount){
        hp += amount;
        if(hp > MaxHp){hp = MaxHp;}
    }
    void defen(int d){
        this.score += d;
    }
}

class Capobstacle {
    private String name;
    private int damage;
    private int need;
    Capobstacle(String name,int damage,int need){
        this.name = name;
        this.damage = damage;
        this.need = need;
    }
    String GetName(){ return this.name; }
    int GetDamage(){ return this.damage; }
    int GetNeed(){ return this.need; }
    void SetDamage(int d){damage = d;}
    void show() {
        System.out.println("名称：" + name + "，伤害：" + damage + "，需要：" + need);
    }
}

class wall extends Capobstacle {
    wall(int damage){
        super("高墙",damage,1);
    }
}

class dilan extends Capobstacle {
    dilan(int damage){
        super("低栏",damage,1);
    }
}

class xianjing extends Capobstacle {
    xianjing(int damage){
        super("陷阱",damage,2);
    }
}

class hudun extends Capobstacle {
    hudun(){
        super("护盾",0,0);
    }
}

class yaoshui extends Capobstacle {
    int amount;
    yaoshui(){
        super("药水",0,0);
        amount = 30;
    }
    int GetAmount(){
        return this.amount;
    }
}

public class PhaseC {
    public static void main(String[] args) {
        ArrayList<Capobstacle> obstacles = new ArrayList<Capobstacle>();
        obstacles.add(new wall(20));
        obstacles.add(new dilan(10));
        obstacles.add(new xianjing(50));
        obstacles.add(new hudun());
        obstacles.add(new yaoshui());
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        int hudunTime = 0;
        int lianji = 0;
        int Maxlianji = 0;
        Playerc p = new Playerc("小明");

        for(int guan = 0; guan < 5; guan++){
            for(int i = 0; i < 10; i++){
                if (hudunTime > 0) hudunTime--;   // 护盾倒计时：只在有盾时减，不会变负
                Capobstacle ob = obstacles.get(rnd.nextInt(obstacles.size()));
                int d = ob.GetDamage() * (guan + 1);   // 伤害按关卡递增，障碍自身伤害不动
                System.out.println("第" + (guan+1) + "关，第" + (i+1) + "步，" + ob.GetName() + "，伤害为" + d);
                System.out.println("请输入你的操作：1.跳跃 2.闪避陷阱 0.拾取");
                ob.show();
                int act = sc.nextInt();
                if(ob instanceof hudun) {
                    hudunTime = 3;
                    System.out.println("捡到护盾！接下来3步免疫");
                } else if(ob instanceof yaoshui) {
                    p.heal(((yaoshui) ob).GetAmount());
                    System.out.println("喝下药水，回血" + ((yaoshui) ob).GetAmount());
                } else {
                    if(hudunTime > 0) {
                        System.out.println("护盾挡住，免疫伤害");   // 有盾时普通障碍也免疫
                    } else if(act == ob.GetNeed()) {
                        System.out.println("成功躲避，免疫伤害");
                        lianji++;   // 只有主动正确躲避才算连击
                    } else {
                        p.gethurt(d);
                        lianji = 0;
                    }
                }

                if(p.Gethp() <= 0){
                    System.out.println("游戏结束，你倒下了！");
                    System.out.println("最终分数：" + p.Getscore() + "，最大连击：" + Maxlianji);
                    return;   // 人死了直接结束整个游戏，不再开下一关
                }

                if (lianji >= 3) {
                    p.defen(30);
                    System.out.println("连击达成！当前分数" + p.Getscore());
                }
                if(lianji > Maxlianji){ Maxlianji = lianji; }
            }
        }

        System.out.println("恭喜通关！");
        System.out.println("最终分数：" + p.Getscore() + "，最大连击：" + Maxlianji);
    }
}
