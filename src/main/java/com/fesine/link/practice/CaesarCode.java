package com.fesine.link.practice;

import com.fesine.link.doubleLink.DualChain;
import com.fesine.link.doubleLink.DualNode;

/**
 * @description: (凯撒密码)双向链表实现，当然使用循环链表也可以实现
 * @author: Fesine
 * @createTime:2017/8/10 20:54
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2017/8/10 20:54
 */
public class CaesarCode {

    /**
     * 根据输入的n值，从第n个字母开始循环输出26个字母
     * @param n
     */
    public void printChar(DualChain<Character> dc,int n) {
        //去掉head
        dc.getHead().getTail().setHead(dc.getTail());
        dc.getTail().setTail(dc.getHead().getTail());
        System.out.println();
        if (n > 0) {
            int i=0;
            int j=0;
            for (DualNode dn = dc.getTail(); dn != null; dn = dn.getTail()) {
                if (i < n) {
                    i++;
                } else {
                    if (j < 26) {
                        System.out.print(dn.getData());
                        j++;
                    } else break;
                }

            }
        }
        if (n < 0) {
            int i = 0;
            int j = 0;
            for (DualNode dn = dc.getHead().getTail(); dn != null; dn = dn.getHead()) {
                if (i > n) {
                        i--;
                } else {
                    if (j < 26) {
                        System.out.print(dn.getData());
                        j++;
                    } else break;
                }
            }
        }

        System.out.println();


    }

    public static DualChain<Character> init() {
        DualChain<Character> dc = new DualChain<>();
        for (int i = 1; i <= 26; i++) {
            char c= (char) (64+i);
            dc.addNode(c);
        }
        System.out.println("创建了\t" + 26 + "\t个元素的环");
        return dc;
    }

    public static void main(String[] args) {
        CaesarCode p = new CaesarCode();
        DualChain<Character> dc = init();
        p.printChar(dc,-999);
        p.printChar(dc,999);
        p.printChar(dc,10);
        p.printChar(dc,26);
        p.printChar(dc,1);
        p.printChar(dc,-1);
    }

}
