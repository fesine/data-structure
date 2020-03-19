package com.fesine.link.practice;

import com.fesine.link.Person;
import com.fesine.link.PersonChainCircle;
import com.fesine.link.PersonChainNode;

/**
 * @description: 拉丁方阵：也是利用循环链表实现
 * 1 2 3 4
 * 2 3 4 1
 * 3 4 1 2
 * 4 1 2 3
 * @author: Fesine
 * @createTime:2017/8/10 20:24
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2017/8/10 20:24
 */
public class LatinMatrix {

    /**
     * 输入一个数字，输出从1到n的拉丁方阵
     * 依然是利用PersonChainCircle实现
     *
     * @param n
     */
    public void latinMatrix(int n) {
        PersonChainCircle pcc = new PersonChainCircle();
        Person p;
        for (int i = 1; i <= n; i++) {
            p = new Person(i, "", 10);
            pcc.addNode(p);
        }
        System.out.println("创建了\t" + n + "\t个元素的环");
        //去掉head
        pcc.getRear().setNextNode(pcc.getHead().getNextNode());
        int m = 1;
        int j = 1;
        boolean flag = true;
        //循环总元素数量的次数
        while (m <= n) {
            //由j控制输出结束位置，当j=n的时候结束
            for (PersonChainNode pcn = pcc.getHead(); pcn != null && j <= n; pcn = pcn.getNextNode
                    ()) {
                //查找第一个输出元素，找到之后退出内循环，开始输出元素
                if (flag) {
                    for (int i = 0; i < m; i++) {
                        pcn = pcn.getNextNode();
                    }
                    flag = false;
                }
                System.out.print(pcn.getPerson().getPersonNo() + "\t");
                j++;
            }
            //递增开始输出位置
            m++;
            //重置条件
            j = 1;
            flag = true;
            System.out.println();
        }

    }

    public static void main(String[] args) {
        new LatinMatrix().latinMatrix(10);
    }

}
