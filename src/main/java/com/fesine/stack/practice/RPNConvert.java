package com.fesine.stack.practice;

import com.fesine.stack.StackChain;
import com.fesine.stack.StackNode;

/**
 * @description: 中缀表达式转后缀表达式 利用栈实现
 * 1+(2-3)*4+10/5 ---->1 2 3 - 4 * + 10 5 / +
 * 实现原理：
 * 1、数字直接输出，注意处理多位数的情况
 * 2、遇到右括号，栈内元素出栈，直到遇到左括号结束，出栈元素输出
 * 3、加减号处理，如果是空栈，直接入栈，如果非空，当栈非空且出栈元素不为左括号时
 * 则循环栈内元素出栈，如果出栈元素左括号则重新入栈，最后加减号入栈
 * 4、乘除号及左括号处理，直接入栈
 * 说明，因为* / 号比+ -号优先级高，所以* /号遇到+-号，直接入栈，反之则
 * @author: Fesine
 * @createTime:2017/8/17 19:10
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2017/8/17 19:10
 */
public class RPNConvert {

    /**
     * 中缀转后缀
     *
     * @param fun
     * @return
     */
    public static String rpnConvert(String fun) {
        //初始化栈
        StackChain<Character> sc = new StackChain<>(100);
        char[] charArr = fun.toCharArray();
        StackNode node;
        //flag控制多位数的无空格连续输出
        boolean flag = false;
        StringBuffer sb = new StringBuffer();
        for (char c : charArr) {
            if (c >= '0' && c <= '9') {
                if (flag) {
                    sb.append(" ");
                    flag = false;
                }
                //数字直接输出
                sb.append(c);

                //处理）元素
            } else if (')' == c) {
                flag = true;
                //元素出栈
                node = sc.pop();
                //遇到（ 出栈停止
                while ('(' != (Character) node.getData()) {
                    sb.append(" " + node.getData());
                    node = sc.pop();
                }
            } else if ('+' == c || '-' == c) {
                flag = true;
                //如果是+-号
                if (sc.empty()) {
                    //空栈，直接入栈
                    sc.push(new StackNode(c));
                } else {
                    do {
                        //执行出栈
                        node = sc.pop();
                        if ('(' == (Character) node.getData()) {
                            //遇到（，重新进栈
                            sc.push(node);
                        } else {
                            //否则输出出栈元素
                            sb.append(" " + node.getData());
                        }
                        //当栈不为空，且不为（号时循环操作
                    } while (!sc.empty() && '(' != (Character) node.getData());
                    //入栈+-号
                    sc.push(new StackNode(c));
                }
                //* / ( 直接入栈
            } else if ('*' == c || '/' == c || '(' == c) {
                flag = true;
                sc.push(new StackNode(c));
            } else {
                System.out.println("转换错误！");
            }
        }
        //处理最后栈内元素
        while (!sc.empty()) {
            sb.append(" " + sc.pop().getData());
        }
        return sb.toString();
    }

    /**
     * 计算后缀表达式结果
     * 元素入栈遇到计算符号，取出两个元素，进行计算，结果再入栈，直到完全处理完成。
     *
     * @param str
     * @return
     */
    public static Integer getResult(String str) {
        //初始化栈
        StackChain<String> sc = new StackChain<>(100);
        String[] strArr = str.split(" ");
        Integer i;
        Integer j;
        for (String s : strArr) {
            if ("+".equals(s)) {
                i = (Integer) sc.pop().getData();
                j = (Integer) sc.pop().getData();
                sc.push(new StackNode(i+j));
            } else if ("-".equals(s)) {
                i = (Integer) sc.pop().getData();
                j = (Integer) sc.pop().getData();
                sc.push(new StackNode(j - i));
            } else if ("*".equals(s)) {
                i = (Integer) sc.pop().getData();
                j = (Integer) sc.pop().getData();
                sc.push(new StackNode(j * i));
            } else if ("/".equals(s)) {
                i = (Integer) sc.pop().getData();
                j = (Integer) sc.pop().getData();
                sc.push(new StackNode(j / i));
            } else {
                Integer k = Integer.parseInt(s);
                sc.push(new StackNode(k));
            }
        }

        return (Integer) sc.pop().getData();
    }

    public static void main(String[] args) {
        String str = "11+(22-323)*46+108/53";
        System.out.println(RPNConvert.rpnConvert(str));
        str = "1+(2-3)*4+10/5";
        String result = RPNConvert.rpnConvert(str);
        System.out.println();
        System.out.println(RPNConvert.getResult(result));
    }
}
