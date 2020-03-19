package com.fesine.queue;

/**
 * @description: 队列功能实现
 * @author: Fesine
 * @createTime:2017/8/17 23:03
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2017/8/17 23:03
 */
public class QueueChain<E> {

    private int size;
    //头节点
    private QNode<E> front;
    //尾节点
    private QNode<E> rear;


    /**
     * 入队，从尾部进入
     * @param e
     */
    public void enQueue(E e) {
        //空节点
        if (front == null) {
            front = new QNode<>(null, null);
            rear = new QNode<>(e,null);
            front.setNext(rear);
        } else {
            QNode<E> tmp = new QNode<>(e,null);
            rear.setNext(tmp);
            rear = tmp;
        }
        size++;
    }

    /**
     * 出队，从头部出来
     * @return
     */
    public QNode<E> deQueue(){
        if (size == 0) {
            return null;
        }
        QNode<E> node;
        if (size == 1) {
            node = front.getNext();
            rear = null;
            front.setNext(null);
        } else {
            node = front.getNext();
            front.setNext(front.getNext().getNext());
        }
        size--;
        return node;
    }

    /**
     * 清空队列
     */
    public void clearQueue(){
        size=0;
        front=null;
        rear=null;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean empty(){
        return size==0;
    }

    public int size(){
        return this.size;
    }

    public QNode<E> getFront() {
        return front;
    }

    public void setFront(QNode<E> front) {
        this.front = front;
    }

    public QNode<E> getRear() {
        return rear;
    }

    public void setRear(QNode<E> rear) {
        this.rear = rear;
    }

    public static void main(String[] args) {
        QueueChain<Integer> qc = new QueueChain<>();
        qc.enQueue(1);
        qc.enQueue(2);
        qc.enQueue(3);
        qc.enQueue(4);
        System.out.println();
        QNode<Integer> front = qc.getFront();
        qc.deQueue();
        qc.deQueue();
        qc.clearQueue();
        qc.deQueue();
        qc.deQueue();
        qc.enQueue(2);
        qc.enQueue(3);
        System.out.println();
    }
}
