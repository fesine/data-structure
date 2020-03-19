package com.fesine.stack;

import java.util.Arrays;

/**
 * @description: 栈功能实现
 * @author: Fesine
 * @createTime:2017/8/14 19:34
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2017/8/14 19:34
 */
public class StackChain<E> {
    private StackNode<E>[] nodes;
    private int top;


    /**
     * 初始化栈
     * @param max
     */
    public StackChain(int max) {
        nodes = new StackNode[max];
        top=-1;
    }

    /**
     * 进栈 动态扩容
     * @param e
     */
    public void push(StackNode e) {
        if (top == nodes.length - 1) {
            nodes = Arrays.copyOf(nodes, nodes.length * 3 / 2);
        }
        ++top;
        nodes[top]=e;

    }

    /**
     * 出栈，将顶部元素返回
     * 同时删除顶部元素
     * @return
     */
    public StackNode pop() {
        if (top == -1) {
            return null;
        }
        StackNode e = nodes[top];
        nodes[top] = null;
        if (top == nodes.length * 2 / 3) {
            nodes = Arrays.copyOf(nodes, top);
        }
        top--;
        return e;

    }

    /**
     * 清空栈
     */
    public void clear(){
        nodes = null;
        top=-1;
    }

    /**
     * 栈是否为空
     * @return
     */
    public boolean empty(){
        return top == -1;
    }

    public StackNode<E>[] getNodes() {
        return nodes;
    }

    public void setNodes(StackNode<E>[] nodes) {
        this.nodes = nodes;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public static void main(String[] args) {
        StackChain<Integer> sc = new StackChain<>(2);
        sc.push(new StackNode(1));
        sc.push(new StackNode(2));
        sc.push(new StackNode(3));
        sc.push(new StackNode(4));
        sc.push(new StackNode(5));
        sc.push(new StackNode(6));
        sc.push(new StackNode(7));
        System.out.println();
        sc.pop();
        sc.pop();
        sc.pop();
        sc.pop();
        sc.pop();
        sc.pop();
        sc.pop();
        System.out.println();
    }
}
