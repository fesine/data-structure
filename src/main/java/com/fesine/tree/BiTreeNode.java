package com.fesine.tree;

/**
 * @description: 二叉树节点
 * @author: Fesine
 * @createTime:2017/8/20 22:18
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2017/8/20 22:18
 */
public class BiTreeNode {
    //数据项
    Integer data;
    //左孩子
    BiTreeNode lchild;
    //右孩子
    BiTreeNode rchild;

    public BiTreeNode(Integer data) {
        this.data = data;
        this.lchild = null;
        this.rchild = null;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public BiTreeNode getLchild() {
        return lchild;
    }

    public void setLchild(BiTreeNode lchild) {
        this.lchild = lchild;
    }

    public BiTreeNode getRchild() {
        return rchild;
    }

    public void setRchild(BiTreeNode rchild) {
        this.rchild = rchild;
    }
}
