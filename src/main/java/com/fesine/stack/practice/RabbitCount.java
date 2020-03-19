package com.fesine.stack.practice;

/**
 * @description: 兔子出生问题递归实现
 * @author: Fesine
 * @createTime:2017/8/17 19:02
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2017/8/17 19:02
 */
public class RabbitCount {
    public static int fun(int n) {
        if (n < 2) {
            return n == 0 ? 0 : 1;
        } else {
            return fun(n - 2) + fun(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(RabbitCount.fun(10));
    }
}
