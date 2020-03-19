package com.fesine.kmp;

/**
 * @description: 类描述
 * @author: Fesine
 * @createTime:2017/8/20 14:15
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2017/8/20 14:15
 */
public class KMP2 {

    /**
     * 根据t字符串返回next数组
     * abababaaac
     *
     * @param t
     * @return
     */
    public static Integer[] getNext(String t) {
        Integer[] next = new Integer[t.length() + 1];
        next[1] = 0;
        int i = 1;
        int j = 0;
        while (i < t.length()) {
            if (j == 0 || t.charAt(i) == t.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                //只改变j的值，不改变i的值
                j = next[j];
            }
        }
        return next;
    }

    public static int getIndex(String s, String t) {
        Integer[] next = getNext(t);
        int i = 0;
        int j = 1;
        while (i < s.length() && j < t.length()) {
            if (j == 0 || s.charAt(i) == t.charAt(j-1)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j > t.length()) {
            return i - j;
        }
        return -1;
    }

    public static void main(String[] args) {
        int index = getIndex("abababaaac", "aac");
        System.out.println(index);
    }
}
