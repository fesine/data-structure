package com.fesine.queue;

/**
 * @description: 循环队列的模实现
 * @author: Fesine
 * @createTime:2017/8/19 13:24
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2017/8/19 13:24
 */
public class QueueCircle<T> {

    /**
     * 队列最大长度
     */
    private int maxSize;
    /**
     * 头元素位置
     */
    private int front;
    /**
     * 尾元素位置
     */
    private int rear;
    //数组
    private Object[] queArray;

    public QueueCircle(int maxSize) {
        this.maxSize = maxSize;
        queArray = new Object[maxSize];
        front = 0;
        rear = 0;
    }

    public boolean isEmpty() {
        return front == rear && queArray[front] == null;
    }

    public boolean isFull() {
        return rear%maxSize==front && queArray[front]!=null;
    }


    /**
     * 入队
     *
     * @param e
     */
    public void enQueue(T e) {
        if (isFull()) return;
        queArray[rear] = e;
        rear = (rear+1)%maxSize;
    }

    /**
     * 出队
     *
     * @return
     */
    public T deQueue() {
        if (isEmpty()) {
            return null;
        }
        T e = (T) queArray[front];
        queArray[front] = null;
        front = (front+1)%maxSize;
        return e;
    }

    public T getFront() {
        if (isEmpty()) {
            return null;
        }
        return (T) queArray[front];
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        } else if (rear > front) {
            return rear - front;
        } else {
            return rear - front + maxSize;
        }
    }

    public static void main(String[] args) {
        QueueCircle<Integer> qc = new QueueCircle<>(4);
        qc.enQueue(1);
        qc.enQueue(2);
        qc.enQueue(3);
        qc.enQueue(4);
        System.out.println(qc.size());
        qc.deQueue();
        qc.deQueue();
        System.out.println(qc.size());
        qc.enQueue(5);
        qc.enQueue(6);
        System.out.println(qc.size());
        System.out.println();
    }
}
