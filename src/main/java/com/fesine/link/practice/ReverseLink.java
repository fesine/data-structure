package com.fesine.link.practice;

/**
 * @description: 一个链表数据为1-4-3-8 --->反向输出为8-3-4-1
 * @author: fesine
 * @createTime:2020/3/19
 * @update:修改内容
 * @author: fesine
 * @updateTime:2020/3/19
 */
public class ReverseLink {
    /**
     * 链表反向输出
     * @param node
     */
    public void solution(Node node){
        if(node == null){
            return;
        }
        if(node.next != null){
            solution(node.next);
        }
        System.out.println(node.data);

    }

    public static void main(String[] args) {
        Node node = new Node(1, null);
        Node node1 = new Node(4, null);
        Node node2 = new Node(3, null);
        Node node3 = new Node(8, null);
        node.next=node1;
        node1.next=node2;
        node2.next=node3;

        new ReverseLink().solution(node);
    }

}

class Node{
    /**
     * 存放数据
     */
    Integer data;
    /**
     * 下一节点
     */
    Node next;

    public Node(Integer data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
