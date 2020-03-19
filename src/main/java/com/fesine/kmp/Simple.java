package com.fesine.kmp;

/**
 * @description: 普通的文字匹配算法BF
 * @author: Fesine
 * @createTime:2016/9/23 22:07
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2016/9/23 22:07
 */
public class Simple {
    int getIndex(String text, String pattern) {
        int slen = text.length();
        int plen = pattern.length();
        int i = 0;
        int j = 0;
        //i和j分别为两个字符串匹配下标
        //循环匹配对应位置的字段
        while (i < slen && j < plen) {
            //如果对应字段匹配，则继续匹配后面的字段，直到匹配字段全部匹配完成，
            // 否则匹配字段位置归0，被匹配字段位置向后移1位
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        //全部匹配成功，返回匹配起始位置
        if (j == plen) {
            return i - j;
        } else {
            return -1;
        }

    }

    public static void main(String[] args) {
        Simple s = new Simple();
        System.out.println(s.getIndex("aabcdefefeabgozeg", "aeb"));
    }
}
