package com.fesine.stack.practice;

/**
 * @description: 利用递归实现汉诺塔问题
 * @author: Fesine
 * @createTime:2017/8/19 15:03
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2017/8/19 15:03
 */
public class HanoTower {

    public static void move(int n, char x, char y, char z) {
        //如果n=1，直接从x移到z
        if (n == 1) {
            System.out.println(x + "---->" + z);
        } else {
            //借助z，第n-1个盘子从x移到y
            move(n - 1, x, z, y);
            //将第n个盘子从x移到z上
            System.out.println(x + "---->" + z);
            //，借助x，将第n-1个盘子从y移到z上
            move(n-1,y,x,z);
        }
    }

    public static void main(String[] args) {
        move(3, 'X', 'Y', 'Z');
    }
}
