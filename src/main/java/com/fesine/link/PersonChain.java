package com.fesine.link;

/**
 * @description: 单向链表
 * @author: Fesine
 * @createTime:2017/8/3 23:22
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2017/8/3 23:22
 */
public class PersonChain {
    private int size; //节点的数量
    private PersonChainNode head; //头节点
    private int modCount;//链表被操作的次数(备用)

    public int getSize() {
        return this.size;
    }

    /**
     * 添加节点的一般方法
     *
     * @param p 添加到链表节点的对象，使用personNo作为唯一标识
     */
    public void addNode(Person p) {
        //如果链表中无该对象，则进行添加
        if (!contains(p.personNo)) {
            if (head != null) {
                //新添加一个头结点，并将下一结点指向原来的头结点
                head = new PersonChainNode(p, head);
            } else {
                //头结点为空，则添加头结点，其后结点为空
                head = new PersonChainNode(p, null);
            }
            size++;
            modCount++;
        }
    }

    public void delete(int personNo) {
        //当前链表数为0直接返回
        if (size == 0) {
            return;
        }
        if (size == 1) {
            //如果只有一个节点，且正好是需要删除的对象
            if (head.person.personNo == personNo) {
                head = null;
                size = 0;
            }
            return;
        }
        //如果当前链表不包含需要删除的对象
        if (!contains(personNo)) {
            return;
        }
        //复杂删除
        int index = 0;
        for (PersonChainNode p = head; p != null; p = p.nextNode) {
            if (p.person.personNo != personNo) {
                index++;
            } else {
                break;
            }
        }
        //正好是头结点
        if (index == 0) {
            //则将下一个节点作为头结点，且下一节点指向下下一个节点
            head = new PersonChainNode(head.nextNode.person, head.nextNode.nextNode);
            size--;
            modCount++;
            return;
        }
        //如果删除的不是头结点,循环遍历找到对应的结点
        int count = 0;
        for (PersonChainNode p = head; p != null; p = p.nextNode) {
            //获取删除节点的前一节
            if (count ==index-1) {
                //如果删除的是最后一个节点
                if (index == size - 1) {
                    p.nextNode = null;//将最后一个置空
                } else {
                    p.nextNode = p.nextNode.nextNode;
                }
                size--;
                modCount++;
                return;
            }
            //没有找到索引+1
            count++;
        }
    }

    /**
     * 根据编号查找对象
     * @param personNo
     * @return
     */
    public Person searchNode(int personNo) {
        Person person = null;
        for (PersonChainNode p = head; p != null; p = p.nextNode) {
            if (p.person.personNo == personNo) {
                person=p.person;
                break;
            }
        }
        return person;
    }

    public void editNode(int personNo, Object value) {
        if (value == null) {
            return;
        }
        Person target = searchNode(personNo);
        if (null == target) {
            return;
        }
        //如果是字符类型，则更改姓名
        if (value.getClass() == String.class) {
            target.name = value.toString();
            return;
        }
        //如果是整型，则更改年龄
        try {
            target.age = Integer.parseInt(value.toString());
        } catch (Exception e) {
            //类型转换错误，退出
            return;
        }

    }

    /**
     * 判断对象是否包含在链表中
     *
     * @param personNo 对象编号
     * @return
     */
    public boolean contains(int personNo) {
        if (size != 0) {
            for (PersonChainNode pcn = head; pcn != null; pcn = pcn.nextNode) {
                if (pcn.person.personNo == personNo) {
                    return true;
                }
            }
        }
        return false;
    }

    public PersonChainNode getHead() {
        return head;
    }
}
