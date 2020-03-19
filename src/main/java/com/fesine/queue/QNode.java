package com.fesine.queue;

/**
 * @description: 队列节点
 * @author: Fesine
 * @createTime:2017/8/17 23:01
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2017/8/17 23:01
 */
public class QNode<E> {
    //数据元素
    E data;

    //下一节点
    QNode<E> next;

    public QNode(E data, QNode<E> next) {
        this.data = data;
        this.next = next;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public QNode<E> getNext() {
        return next;
    }

    public void setNext(QNode<E> next) {
        this.next = next;
    }
}
