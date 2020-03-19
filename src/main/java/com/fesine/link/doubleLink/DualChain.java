package com.fesine.link.doubleLink;

/**
 * @description: 类描述
 * @author: Fesine
 * @createTime:2017/8/10 21:47
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2017/8/10 21:47
 */
public class DualChain<E> {
    private int size;
    private int modCount;
    private DualNode head;
    private DualNode tail;

    /**
     * 添加元素时，如果是空链表，则创建空head
     * 创建有元素的tail，其head指向head
     * head的tail指向tail
     *
     * @param e
     */
    public void addNode(E e) {
        if (tail != null) {
            DualNode<E> tmp = new DualNode<>(e, tail, tail.getTail());
            tail.setTail(tmp);
            tail=tmp;
        } else {
            //空链表
            head = new DualNode<>(null, null, null);
            tail = new DualNode<>(e, head, null);
            head.setTail(tail);
        }
        size++;
        modCount++;
    }

    public void delete(E e) {
        if (size == 0) {
            return;
        }
        if (size == 1) {
            if (tail.data == e) {
                head.tail=tail;
                tail.head=head;
                tail=null;
                size=0;
                modCount++;
            }
            return;
        }
        if (!contains(e)) {
            return;
        }

        //复杂删除
        int index=0;
        for (DualNode dn = head.tail; dn != null; dn = dn.tail) {
            if (dn.data != e) {
                index++;
            }else break;
        }
        //正好是第一个节点，则头结点指向第二个节点
        if (index == 0) {
            head.tail = head.tail.tail;
            head.tail.head=head;
            size--;
            modCount++;
            return;
        }
        //遍历找到需要删除的节点
        int count=0;
        for (DualNode dn = head.tail; dn != null; dn = dn.tail) {
            if (count == index - 1) {
                if (index == size - 1) {
                    dn.tail = null;
                    tail = dn;
                } else {
                    dn.tail = dn.tail.tail;
                    dn.tail.head=dn;
                }
                size--;
                modCount++;
                return;
            }
            count++;
        }
    }

    /**
     * 编辑元素
     * @param target
     * @param e
     */
    public void editNode(E target,E e) {
        if (target == null && e == null) {
            return;
        }
        for (DualNode dn = head.tail; dn != null; dn = dn.tail) {
            if (dn.data == target) {
                dn.data = e;
                modCount++;
                break;
            }
        }


    }

    /**
     * 寻找元素
     * @param e
     * @return
     */
    public E searchNode(E e) {
        E tmp=null;
        for (DualNode dn = head.tail; dn != null; dn = dn.tail) {
            if (dn.data == e) {
                tmp = e;
                break;
            }
        }
        return tmp;
    }

    /**
     * 判断链表中是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e) {
        if (size != 0) {
            for (DualNode dn = head.tail; dn != null; dn = dn.tail) {
                if (dn.data == e) {
                    return true;
                }
            }
        }
        return false;
    }




    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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

    public static void main(String[] args) {
        DualChain<Integer> dc = new DualChain<>();
        dc.addNode(1);
        dc.addNode(2);
        dc.addNode(3);
        dc.addNode(4);
        dc.addNode(5);
        dc.delete(2);
        dc.editNode(4,8);
        //dc.addNode(1);
        System.out.println(dc.searchNode(4));
    }
}
