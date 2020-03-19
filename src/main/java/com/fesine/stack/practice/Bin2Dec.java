package com.fesine.stack.practice;

import com.fesine.stack.StackChain;
import com.fesine.stack.StackNode;

/**
 * @description: 二进制向十进制转换
 * @author: Fesine
 * @createTime:2017/8/14 20:36
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2017/8/14 20:36
 */
public class Bin2Dec {

    public static StackChain<Character> init(String binStr) {
        int len = binStr.length();
        StackChain<Character> sc = new StackChain<>(len);
        for (int i = 0; i < len; i++) {
            sc.push(new StackNode(binStr.charAt(i)));
        }
        return sc;
    }

    public static int bin2Dec(String binStr){
        StackChain<Character> sc = init(binStr);
        int sum = 0;
        for (int i = 0; i < binStr.length(); i++) {
            Character c = (Character) sc.pop().getData();
            sum = (int) (sum + (c - 48) * Math.pow(2, i));
        }
        return sum;
    }

    public static String bin2Oct(String binStr) {
        int len = binStr.length();
        StackChain<Character> sc = init(binStr);
        int j = len % 3 == 0?len/3:len/3+1;
        StackChain<Character> sco = new StackChain<>(j);

        int sum = 0;
        for (int i = 1; i <= len; i++) {
            Character c = (Character) sc.pop().getData();
            sum = (int) (sum + (c - 48) * Math.pow(2, (i - 1) % 3));
            if (i % 3 == 0) {
                sco.push(new StackNode(sum));
                sum = 0;
            }
        }
        if (sum != 0) {
            sco.push(new StackNode(sum));
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < j; i++) {
            sb.append(sco.pop().getData());
        }
        return sb.toString();
    }

    public static String bin2Hex(String binStr) {
        int len = binStr.length();
        StackChain<Character> sc = init(binStr);
        int j = len % 4 == 0?len/4:len/4+1;
        StackChain<Character> sco = new StackChain<>(j);

        int sum = 0;
        StackNode sn;
        for (int i = 1; i <= len; i++) {
            Character c = (Character) sc.pop().getData();
            sum = (int) (sum + (c - 48) * Math.pow(2, (i - 1) % 4));

            if (i % 4 == 0) {
                if (sum > 9) {
                    sn = new StackNode((char)(sum + 55));
                } else sn = new StackNode(sum);
                sco.push(sn);
                sum = 0;
            }
        }
        if (sum != 0) {
            if (sum > 9) {
                sn = new StackNode(sum + 55);
            } else sn = new StackNode(sum);
            sco.push(sn);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < j; i++) {
            sb.append(sco.pop().getData());
        }
        return sb.toString();
    }




    public static void main(String[] args) {
        //二进制转十进制
        String binStr="11111100101";
        //binStr="11001001";
        //二进制到八进制，每三位数相加
        //11001001 = 3 1 1
        //2-8
        System.out.println(bin2Oct(binStr));
        //2-10
        System.out.println(bin2Dec(binStr));
        //2-16
        System.out.println(bin2Hex(binStr));

    }
}
