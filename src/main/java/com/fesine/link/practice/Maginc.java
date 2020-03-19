package com.fesine.link.practice;

import com.fesine.link.Person;
import com.fesine.link.PersonChainCircle;
import com.fesine.link.PersonChainNode;

/**
 * @description:
 * *问题名称：魔术师发牌问题
 *  问题描述：魔术师手里一共有13张牌，全是黑桃，1~13.
 *********魔术师需要实现一个魔术：这是十三张牌全部放在桌面上（正面向下），
 ********第一次摸出第一张，是1，翻过来放在桌面上。
 ******第二次摸出从上往下数第二张，是2，翻过来 放在桌面上，（第一张放在最下面去，等会儿再摸），
 *****第三次摸出从上往下数第三张，是3，翻过来放在桌面上，（第一张和第二张 放在最下面去，等会儿再摸）
 ***  以此类推 最后一张就是13
 * @author: Fesine
 * @createTime:2017/8/8 23:13
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2017/8/8 23:13
 */
public class Maginc {

    /**
     * 使用循环链表处理
     */
    public PersonChainCircle cratemMagicPoker(){
        //1、初始化13个节点值为0的链表
        PersonChainCircle pcc = new PersonChainCircle();
        Person p= new Person(0,"",100) ;
        for (int i = 0; i < 13; i++) {
            pcc.addNode(p);
        }
        System.out.println("成功生成\t" + pcc.getSize() + "个\t元素环！");
        //去掉head:将尾结点的下一节点指向头结点的下一结点，构成无头结点的环
        pcc.getRear().setNextNode(pcc.getHead().getNextNode());
        int i = 1;
        int j = 1;
        //从1开始处理
        for (PersonChainNode pcn = pcc.getHead().getNextNode(); pcn != null; pcn = pcn.getNextNode
                ()) {
            if (i > 13) break;
            //放1，接着放2，3，4
            //判断当前是否可放
            if (pcn.getPerson().getPersonNo() == 0){
                //如果可放，且正好是要放的数，则放入数字，同时恢复从1计数，放下一个数
                if (i == j) {
                    pcn.setPerson(new Person(i, "", 100));
                    i++;
                    j = 1;
                }else j++;//如果不是要放的数字，则取下一张
            }
        }
        return pcc;
    }

    public static void main(String[] args) {
        Maginc maginc = new Maginc();
        PersonChainCircle pcc = maginc.cratemMagicPoker();
        int i=1;
        System.out.println("13张牌的顺序是：");
        for (PersonChainNode pcn = pcc.getHead().getNextNode(); pcn != null; pcn = pcn.getNextNode
                ()) {
            if (i > 13) {
                break;
            }
            System.out.print(pcn.getPerson().getPersonNo() + ",");
            i++;
        }
        System.out.println();
    }
}
