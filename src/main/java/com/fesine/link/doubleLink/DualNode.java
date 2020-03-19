package com.fesine.link.doubleLink;

/**
 * @description: 类描述
 * @author: Fesine
 * @createTime:2017/8/10 21:43
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2017/8/10 21:43
 */
public class DualNode<E> {
    //数据项
    E data;
    DualNode head;
    DualNode tail;

    public DualNode(E data, DualNode head, DualNode tail) {
        this.data = data;
        this.head = head;
        this.tail = tail;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public DualNode getHead() {
        return head;
    }

    public void setHead(DualNode head) {
        this.head = head;
    }

    public DualNode getTail() {
        return tail;
    }

    public void setTail(DualNode tail) {
        this.tail = tail;
    }
}
