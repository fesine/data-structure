package com.fesine.kmp;

/**
 * @description: 类描述
 * @author: Fesine
 * @createTime:2016/9/23 20:45
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2016/9/23 20:45
 */
public class KMP {
    void getNext(String pattern, int[] next) {
        int j = 0;
        int k = -1;
        int len = pattern.length();//得到字符串长度
        next[0] = -1;//数组第一个元素为-1
        //当j小于字符串长度-1时，因为使用下标，所以从0开始直到长度-1
        while (j < len - 1) {
            /**
             * 首次循环时，进入if语句,j和k自增
             * 或者下标为j的设值为k
             * 否则将k的值设为下标为k的值
             */
            if (k == -1 || pattern.charAt(k) == pattern.charAt(j)) {
                j++;
                k++;
                next[j] = k;//next1=0,next2=0
            } else {
                /**
                 * 比较到第k个字符，说明p[从0到k-1]字符串和p[j-k到j-1]字符串相等，
                 * 而next[k]表示p[从0到k-1]字符串的前缀和后缀的最长共有长度，
                 * 所以接下来可以直接比较p[next[k]]和p[j]
                 */
                k = next[k];
            }
        }
    }

    int kmp(String text, String pattern) {
        int i = 0;
        int j = 0;
        int slen = text.length();
        int plen = pattern.length();
        int[] next = new int[plen];
        getNext(pattern, next);
        while (i < slen && j < plen) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (next[j] == -1) {
                    i++;
                    j = 0;
                } else {
                    j = next[j];
                }
            }
            if (j == plen) {
                return i - j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //String pattern="abcabed";
        //int[] next = new int[pattern.length()];
        //
        //KMP kmp = new KMP();
        //kmp.getNext(pattern, next);

        String str = "abababdafdasabcfdfeaba";
        String pattern = "abda";
        KMP kmp = new KMP();
        System.out.println(kmp.kmp(str, pattern));
    }


}
