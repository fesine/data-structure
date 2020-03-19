package com.fesine.stack.practice;

/**
 * @description: 阶乘递归实现
 * @author: Fesine
 * @createTime:2017/8/19 14:31
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2017/8/19 14:31
 */
public class Factorial {

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int factorial = factorial(5);
        System.out.println(factorial);
    }
}
