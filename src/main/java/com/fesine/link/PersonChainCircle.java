package com.fesine.link;

/**
 * @description: 循环链表(带头结点尾插法) 只有一个节点时，rear节点和next节点均指向自己，
 * 否则next结点指向下一节点，并且最后一个节点的next节点指向头结点
 * @author: Fesine
 * @createTime:2017/8/7 20:35
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2017/8/7 20:35
 */
public class PersonChainCircle {
    private int size; //节点的数量
    private PersonChainNode head, rear; //头节点,尾节点
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
        //if (!contains(p.personNo)) {
            if (rear != null) {
                //链表存在节点
                //1、创建临时节点，添加对象p，并将尾结点指向原rear节点的下一节点（即头节点）
                PersonChainNode tmp = new PersonChainNode(p, head);
                //2、将rear的尾节点指向刚创建的tmp节点，即rear节点的尾结点指向新创建tmp结点
                rear.nextNode = tmp;
                //3、将tmp节点变为rear节点，此rear节点永远指向头结点
                rear = tmp;
            } else {
                //1、空节点时，创建空头结点
                head = new PersonChainNode(null, null);
                //2、创建rear节点并将尾结点指向头结点
                rear = new PersonChainNode(p, head);
                //3、将空头节点的尾结点指向rear节点
                head.nextNode = rear;
            }
            size++;
            modCount++;
        //}
    }

    /**
     * 头插法，每次插入都在头结点后面
     * @param p
     */
    public void addNodeFromHead(Person p) {
        //如果链表中无该对象，则进行添加
        if (!contains(p.personNo)) {
            if (rear != null) {
                //链表存在节点
                //1、rear添加对象p，并将尾结点指向原rear节点
                rear = new PersonChainNode(p, rear);
                //2、将head节点尾节点指向新的rear节点
                head.nextNode = rear;
            } else {
                //1、空节点时，创建空头结点
                head = new PersonChainNode(null, null);
                //2、创建rear节点并将尾结点指向头结点
                rear = new PersonChainNode(p, head);
                //3、将空头节点的尾结点指向rear节点
                head.nextNode = rear;
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
            if (rear.person.personNo == personNo) {
                rear = null;
                size--;
            }
            return;
        }
        //如果当前链表不包含需要删除的对象
        if (!contains(personNo)) {
            return;
        }
        //复杂删除
        int index = 0;
        for (PersonChainNode p = head.nextNode; p.person != null; p = p.nextNode) {
            if (p.person.personNo != personNo) {
                index++;
            } else {
                break;
            }
        }
        //正好是头结点的下一个节点
        if (index == 0) {
            //头结点的下一节点指向下下一个节点
            head.nextNode = head.nextNode.nextNode;
            size--;
            modCount++;
            return;
        }
        //如果删除的不是头结点的下一个节点,循环遍历找到对应的结点
        int count = 0;
        for (PersonChainNode p = head.nextNode; p.person != null; p = p.nextNode) {
            //获取删除节点的前一节
            if (count == index - 1) {
                p.nextNode = p.nextNode.nextNode;
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
     *
     * @param personNo
     * @return
     */
    public Person searchNode(int personNo) {
        Person person = null;
        for (PersonChainNode p = head.nextNode; p.person != null; p = p.nextNode) {
            if (p.person.personNo == personNo) {
                person = p.person;
                break;
            }
        }
        return person;
    }

    public void editNode(int personNo, Object value) {
        if (value == null) {
            return;
        }
        Person target = this.searchNode(personNo);
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
            //从rear的尾节点（即头结点）的下一个节点开始循环
            for (PersonChainNode pcn = head.nextNode; pcn.person != null; pcn = pcn
                    .nextNode) {
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

    public void setHead(PersonChainNode head) {
        this.head = head;
    }

    public PersonChainNode getRear() {
        return rear;
    }

    public void setRear(PersonChainNode rear) {
        this.rear = rear;
    }



    public static void main(String[] args) {
        PersonChainCircle pcc = new PersonChainCircle();
        Person p1 = new Person(1, "fesine", 31);
        Person p2 = new Person(2, "soly", 32);
        Person p3 = new Person(3, "pactera", 33);
        Person p4 = new Person(4, "zjrcu", 34);
        Person p5 = new Person(5, "sucie", 5);
        pcc.addNode(p1);
        pcc.addNode(p2);
        pcc.addNode(p3);
        pcc.addNode(p4);
        pcc.addNode(p5);
        //pcc.addNodeFromHead(p1);
        //pcc.addNodeFromHead(p2);
        //pcc.addNodeFromHead(p3);
        //pcc.addNodeFromHead(p4);
        //pcc.addNodeFromHead(p5);
        System.out.println(pcc.searchNode(4));
        pcc.editNode(4,8);
        System.out.println(pcc.searchNode(4));
        pcc.editNode(4,"hello");
        System.out.println(pcc.searchNode(4));
    }
}
