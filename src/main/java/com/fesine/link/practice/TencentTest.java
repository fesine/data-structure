package com.fesine.link.practice;

import com.fesine.link.Person;
import com.fesine.link.PersonChain;
import com.fesine.link.PersonChainNode;

/**
 * @description: 一次性找出一个链表的中间值
 * @author: Fesine
 * @createTime:2017/8/8 20:55
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2017/8/8 20:55
 */
public class TencentTest {

    /**
     * 快慢指针实现找出一个未知链表的中间值
     * @param personChain
     * @return
     */
    public Person findMiddleElem(PersonChain personChain) {
        //创建两个节点均指向头结点
        //当快节点下一个节点不为空时，执行循环
        //判断快节点下下一个节点是否为空，如果不为空快节点取下下一个节点元素
        //慢节点取下一个节点元素
        //如果快节点下下一个元素为空，则取下一个节点，退出while循环
        //那么此时慢节点即是中间节点元素
        PersonChainNode p = personChain.getHead();
        PersonChainNode mid = p;
        while (p.getNextNode() != null) {
            if (p.getNextNode().getNextNode() !=null) {
                p = p.getNextNode().getNextNode();
                mid = mid.getNextNode();
            }else {
                p = p.getNextNode();
            }
        }
        return mid.getPerson();
    }

    public static void main(String[] args) {
        PersonChain pc = new PersonChain();
        Person p1 = new Person(1, "fesine", 31);
        Person p2 = new Person(2, "soly", 32);
        Person p3 = new Person(3, "pactera", 33);
        Person p4 = new Person(4, "zjrcu", 34);
        Person p5 = new Person(5, "sucie", 5);
        Person p6 = new Person(6, "sun", 5);
        Person p7 = new Person(7, "sun1", 15);
        pc.addNode(p1);
        pc.addNode(p4);
        pc.addNode(p2);
        pc.addNode(p3);
        pc.addNode(p5);
        pc.addNode(p6);
        pc.addNode(p7);
        TencentTest test = new TencentTest();
        Person person = test.findMiddleElem(pc);
        System.out.println(person);
    }
}
