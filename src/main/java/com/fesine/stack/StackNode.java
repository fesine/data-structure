package com.fesine.stack;

/**
 * @description: 栈节点元素
 * @author: Fesine
 * @createTime:2017/8/11 22:40
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2017/8/11 22:40
 */
public class StackNode<E> {

    E data;

    public StackNode(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }


}
