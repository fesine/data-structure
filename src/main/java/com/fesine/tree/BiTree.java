package com.fesine.tree;

import java.util.LinkedList;

/**
 * @description: 二叉树实现，使用前序遍历方式创建：先创建根，再创建左树，最后创建右树
 * @author: Fesine
 *         1
 *     2       3
 *   4   5   6   7
 *  0 0 0 8 0 0 0 0
 * @createTime:2017/8/20 22:20
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2017/8/20 22:20
 */
public class BiTree {

    //根结点
    private BiTreeNode root;
    private int count = 0;


    public BiTreeNode createPreBiTree(String str) {
        BiTreeNode  node= null;
        char c = str.charAt(count);
        if (c != '0') {
            node = new BiTreeNode(Integer.parseInt(c + ""));
            count++;
            node.lchild= createPreBiTree(str);
            count++;
            node.rchild= createPreBiTree(str);
        }
        return node;

    }

    /**
     * 层序创建二叉树
     * @param str
     * @return
     */
    public LinkedList<BiTreeNode> createBiTree(String str){
        char[] strArr = str.toCharArray();
        LinkedList<BiTreeNode> nodes = new LinkedList<>();
        for (char c : strArr) {
            if (c == '0') {
                nodes.add(new BiTreeNode(null));
            }
            else nodes.add(new BiTreeNode(Integer.parseInt(c + "")));
        }
        for (int i = 0; i < strArr.length / 2 - 1; i++) {
            //左孩子
            nodes.get(i).setLchild(nodes.get((i * 2)+1));
            nodes.get(i).setRchild(nodes.get((i * 2)+2));
        }
        int lastIndex = strArr.length / 2 - 1;
        nodes.get(lastIndex).setLchild(nodes.get((lastIndex * 2) + 1));
        if (strArr.length % 2 == 1) {
            nodes.get(lastIndex).setRchild(nodes.get((lastIndex * 2) + 2));
        }
        return nodes;
    }

    /**
     * 创建二叉树，层序
     *
     * @param
     */
    public void createBiTree(BiTreeNode node,Integer data){
        //根节点为空，创建根节点
        if (root == null) {
            root = new BiTreeNode(data);
        } else {
            //判断是创建左节点还是右节点
            if (data < node.data) {
                if (node.getLchild() == null) {
                    node.setLchild(new BiTreeNode(data));
                } else {
                    createBiTree(node.getLchild(), data);
                }
            } else {
                if (node.getRchild() == null) {
                    node.setRchild(new BiTreeNode(data));
                } else {
                    createBiTree(node.getRchild(), data);
                }
            }
        }
    }

    public void preOrder(BiTreeNode node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            preOrder(node.getLchild());
            preOrder(node.getRchild());
        }
    }

    public void inOrder(BiTreeNode node) {
        if (node != null) {
            inOrder(node.getLchild());
            System.out.print(node.getData() + " ");
            inOrder(node.getRchild());
        }
    }

    public void postOrder(BiTreeNode node) {
        if (node != null) {
            postOrder(node.getLchild());
            postOrder(node.getRchild());
            System.out.print(node.getData() + " ");
        }
    }


    public static void main(String[] args) {
        BiTree biTree = new BiTree();
        //int[] a = {20, 10, 30, 5, 13, 25, 34, 3, 6, 11, 14, 22, 26, 32, 36};
        //for (int i = 0; i < a.length; i++) {
        //    biTree.createBiTree(biTree.root, a[i]);
        //}
        //biTree.preOrder(biTree.root);
        //System.out.println();
        //biTree.inOrder(biTree.root);
        //System.out.println();
        //biTree.postOrder(biTree.root);
        //System.out.println();
        //1240050030600
        //String str="1234506";
        //List<BiTreeNode> biTree1 = biTree.createBiTree(str);
        BiTreeNode preBiTree = biTree.createPreBiTree("1240050030600");
        biTree.preOrder(preBiTree);
        System.out.println();
        biTree.inOrder(preBiTree);
        System.out.println();
        biTree.postOrder(preBiTree);
        System.out.println();
    }
}
