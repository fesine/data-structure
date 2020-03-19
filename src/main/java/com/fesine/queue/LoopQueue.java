package com.fesine.queue;

/**
 * @description: 循环队列，使用数组实现
 * @author: Fesine
 * @createTime:2017/8/18 10:07
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2017/8/18 10:07
 */
public class LoopQueue<T> {

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

    public LoopQueue(int maxSize) {
        this.maxSize = maxSize;
        queArray = new Object[maxSize];
        front = 0;
        rear = 0;
    }

    public boolean isEmpty() {
        return front == rear && queArray[front] == null;
    }

    public boolean isFull() {
        return (rear == front && queArray[front] != null);
    }


    /**
     * 入队
     *
     * @param e
     */
    public void enQueue(T e) {
        if (isFull()) return;
        queArray[rear++] = e;
        rear = rear == maxSize ? 0 : rear;
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
        queArray[front++] = null;
        front = front == maxSize ? 0 : front;
        return e;
    }

    public T getFront(){
        if (isEmpty()) {
            return null;
        }
        return (T) queArray[front];
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        else if (rear > front) {
            return rear - front;
        } else {
            return rear - front + maxSize;
        }
    }

    public static void main(String[] args) {
        LoopQueue<Integer> qc = new LoopQueue(4);
        qc.enQueue(1);
        qc.enQueue(2);
        qc.enQueue(3);
        qc.enQueue(4);
        qc.enQueue(5);
        System.out.println(qc.size());
        qc.deQueue();
        qc.deQueue();
        qc.deQueue();
        System.out.println(qc.size());
        qc.enQueue(5);
        qc.enQueue(6);
        qc.enQueue(7);
        System.out.println(qc.size());
    }


}
