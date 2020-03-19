package com.fesine.link.practice;

import com.fesine.link.Person;
import com.fesine.link.PersonChainCircle;
import com.fesine.link.PersonChainNode;

/**
 * @description: 约瑟夫环：已知n个人（以编号1，2，3...n分别表示）围坐在一张圆桌周围。
 * 从编号为k的人开始报数，数到m的那个人出列；他的下一个人又从1开始报数，数到m的那个人又出列；
 * 依此规律重复下去，直到圆桌周围的人全部出列。
 * @author: Fesine
 * @createTime:2017/8/8 21:42
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2017/8/8 21:42
 */
public class JosephProblem {

    /**
     * 生成共total数量环，从第start开始记数，数到count时出列
     *
     * @param total
     * @param start
     * @param count
     */
    public void orderOut(int total, int start, int count) {
        PersonChainCircle pcc = new PersonChainCircle();
        Person p;
        //初始化total数量的环
        for (int i = 1; i <= total; i++) {
            p = new Person(i, "", 0);
            pcc.addNode(p);
        }
        System.out.println("成功生成\t" + pcc.getSize() + "个\t元素环！");
        //去掉head:将尾结点的下一节点指向头结点的下一结点，构成无头结点的环
        pcc.getRear().setNextNode(pcc.getHead().getNextNode());
        //开始报数
        int n = pcc.getSize();
        int m = 1;
        int i =1;
        for (PersonChainNode pcn = pcc.getHead(); pcn != null; pcn = pcn.getNextNode
                ()) {
            //当start时不进行数数操作，直到start为0时，开始数数
            if (start > 0) {
                start--;
                continue;
            } else {

                if (i == count - 1) {
                    System.out.println("第\t" + m + "\t个出列的编号是\t" + pcn.getNextNode().getPerson()
                            .getPersonNo());
                    if (n == 1) {
                        break;
                    }
                    m++;
                    n--;
                    pcn.setNextNode(pcn.getNextNode().getNextNode());
                    i=1;
                    continue;
                }
                i++;
            }
        }
    }

    public static void main(String[] args) {
        JosephProblem jp = new JosephProblem();
        jp.orderOut(41,1,3);
    }
}
