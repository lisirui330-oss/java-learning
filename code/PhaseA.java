package com.njupt.test;
import java.util.ArrayList;
import java.util.Random;
public class PhaseA {
    public static void main(String[] args) {
        PhasePlayer p = new PhasePlayer("xiao Ming", 800);
        ArrayList<PhaseObstacle> mobs = new ArrayList<>();
        mobs.add(new PhaseObstacle("墙", 20));
        mobs.add(new PhaseObstacle("陷阱", 35));
        mobs.add(new PhaseObstacle("无", 0));
        mobs.add(new PhaseObstacle("栏杆", 15));
        Random rnd = new Random();

        int wallCount = 0;
        int trapCount = 0;
        int langanCount = 0;

        for (int g = 0; g < 3; g++) {                 // 外层：3 关
            for (int i = 0; i < 8; i++) {             // 内层：8 步
                int idx = rnd.nextInt(mobs.size());
                PhaseObstacle mob = mobs.get(idx);
                p.gethurt(mob.damage * (g + 1));      // 第1关×1、第2关×2、第3关×3

                if (idx == 0) {
                    wallCount++;
                } else if (idx == 1) {
                    trapCount++;
                } else if (idx == 3) {
                    langanCount++;
                }

                if (p.hp <= 0) {
                    System.out.println("倒在第 " + (g + 1) + " 关 第 " + (i + 1) + " 步");
                    break;                            // 跳出这一关的 8 步
                }
            }

            if (p.hp <= 0) {
                break;                                // 死了就别进下一关
            }
p.hp += 100;
            if(p.hp > 800){
                p.hp = 800;
            }

        }
if(p.hp > 0){
    System.out.println("通关");}
        // TODO C：如果血量还 > 0，打印"通关"；否则什么都不用打（上面已经报了倒在第几关）

        System.out.println("剩余血量：" + p.hp);
        System.out.println("遇到墙：" + wallCount + " 次");
        System.out.println("遇到陷阱：" + trapCount + " 次");
        // TODO B：加一行打印栏杆次数
        System.out.println("遇到栏杆：" + langanCount + " 次");
    }
}

class PhasePlayer{
    String name;
    int hp;
    PhasePlayer(String name,int hp){
        this.name = name;
        this.hp = hp;
    }
    void gethurt(int damage){
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
    }
}

class PhaseObstacle{
    String name;
    int damage;
    PhaseObstacle(String name,int damage){
        this.name = name;
        this.damage = damage;
    }
}
