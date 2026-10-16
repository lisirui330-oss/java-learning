package com.njupt.test;
import java.util.Random;
import java.util.Scanner;
public class PhaseB {
    public static void main(String[] args) {

        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        int r = rnd.nextInt(100) + 1;
        int count = 0;
boolean win = false;
        for(int i = 0; i < 10;i++){
    count++;
    System.out.println("请输入一个数字");
int num = sc.nextInt();
if(num < r){
    System.out.println("小了");}
    else if(num > r) {
    System.out.println("大了");

}
    else{
    System.out.println("对了");
    win = true;
    break;
    }}
    System.out.println("你猜了" + count + "次");
        if(!win){
            System.out.println("你输了正确答案是" + r);}
}}