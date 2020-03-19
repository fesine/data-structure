package com.fesine.link.practice;

import com.fesine.link.doubleLink.DualChain;
import com.fesine.link.doubleLink.DualNode;

/**
 * @description: 维吉尼亚密码，使用非固定密码加密因子加密明文，使用双向链表实现
 * ABCDEFGHIJKLMNOPQRSTUVWXYZ  ->A盘
 * BCDEFGHIJKLMNOPQRSTUVWXYZA  ->B盘
 * CDEFGHIJKLMNOPQRSTUVWXYZAB  ->C盘
 * DEFGHIJKLMNOPQRSTUVWXYZABC  ->D盘
 * .
 * .
 * .
 * ZABCDEFGHIJKLMNOPQRSTUVWXY  ->Z盘
 * 比如密码是HELLOWORLD,加密因子是ABCD
 * 那么
 * 明文HELLOWORLD
 * 因子ABCDABCDAB
 * 密文HFNOOXQULE
 * @author: Fesine
 * @createTime:2017/8/11 20:14
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2017/8/11 20:14
 */
public class VigenereCode {
    /**
     * 加密明文
     *
     * @param source 明文
     * @param dest   加密因子
     * @return 返回密码
     */
    public static String encodeVigenere(String source,String dest) throws Exception {
        //循环加密因子使得长度明文长度相同
        source = source.toUpperCase();
        dest = dest.toUpperCase();
        String cDest  = initDest(source, dest);
        //初始化字母表（双向链表）
        DualChain<Character> dc = CaesarCode.init();
        //去掉head，A和Z相接
        dc.getHead().getTail().setHead(dc.getTail());
        dc.getTail().setTail(dc.getHead().getTail());
        //将字符串转成char数组
        char[] sArr = source.toCharArray();
        char[] dArr = cDest.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < sArr.length; i++) {
            //得到明文位置，1-26数字
            int j = sArr[i] - 64;
            for (DualNode dn = dc.getTail(); dn != null; dn = dn.getTail()) {
                //得到对应字母的起点
                if (dn.getData() == (Character)dArr[i]) {
                    int k = 1;
                    while (k < j) {
                        //往后移动到指定的位置
                        dn = dn.getTail();
                        k++;
                    }
                    sb.append(dn.getData());
                    break;
                }
            }
        }


        return sb.toString();
    }

    public static String decodeVigenere(String source, String dest) throws Exception {
        //循环加密因子使得长度明文长度相同
        source = source.toUpperCase();
        dest = dest.toUpperCase();
        String cDest = initDest(source, dest);
        //初始化字母表（双向链表）
        DualChain<Character> dc = CaesarCode.init();
        //去掉head，A和Z相接
        dc.getHead().getTail().setHead(dc.getTail());
        dc.getTail().setTail(dc.getHead().getTail());
        //将字符串转成char数组
        char[] sArr = source.toCharArray();
        char[] dArr = cDest.toCharArray();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < sArr.length; i++) {
            //得到加密因子位置，1-26数字
            int j = dArr[i] - 64;
            for (DualNode dn = dc.getTail(); dn != null; dn = dn.getTail()) {
                //得到对应字母的起点
                if (dn.getData() == (Character) sArr[i]) {
                    int k = 1;
                    while (k < j) {
                        //往前移动到指定的位置
                        dn = dn.getHead();
                        k++;
                    }
                    sb.append(dn.getData());
                    break;
                }
            }
        }

        return sb.toString();
    }


    private static String initDest(String source, String dest) throws Exception {
        if (source.length() < dest.length()) {
            throw new Exception("加密因子长度大于明文长度");
        }
        int sLen = source.length();
        StringBuffer sb = new StringBuffer(dest);
        while (sb.length() < sLen) {
            sb.append(dest);
        }
        return sb.substring(0, sLen);
    }

    public static void main(String[] args) {
        try {
            String dest = "abcd";
            String s = encodeVigenere("tobeornottobeisaquestion", dest);
            System.out.println(s);
            s = decodeVigenere(s, dest);
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
