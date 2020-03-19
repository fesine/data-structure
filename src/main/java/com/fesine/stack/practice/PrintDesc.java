package com.fesine.stack.practice;

/**
 * @description: 输入任意字符串，反向输出，如ABCD#-->DCBA，使用递归实现
 * @author: Fesine
 * @createTime:2017/8/19 14:17
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2017/8/19 14:17
 */
public class PrintDesc {

    public static void reverse(String str) {
        if (str.length() == 1) {
            System.out.print(str);
        } else {
            String s1 = str.substring(str.length() - 1);
            System.out.print(s1);
            String s2 = str.substring(0, str.length() - 1);
            reverse(s2);
        }
    }

    public static void main(String[] args) {
        PrintDesc.reverse("abcdefg");
        System.out.println();
    }
}
