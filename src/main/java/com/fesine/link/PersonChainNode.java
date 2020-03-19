package com.fesine.link;

/**
 * @description: 节点（实体），封装了person对象和下一个实体的引用
 * 该实体作为单链表的节点
 * @author: Fesine
 * @createTime:2017/8/3 23:18
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2017/8/3 23:18
 */
public class PersonChainNode {
    PersonChainNode nextNode;
    Person person;

    /**
     * 获取当前实体对象
     * @return
     */
    public Person getPerson(){
        return this.person;
    }

    /**
     * 获取下一节点实体
     * @return
     */
    public PersonChainNode getNextNode(){
        return this.nextNode;
    }

    public void setNextNode(PersonChainNode nextNode) {
        this.nextNode = nextNode;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public PersonChainNode(Person person) {
        this.person = person;
    }

    public PersonChainNode(Person person,PersonChainNode nextNode) {
        this.nextNode = nextNode;
        this.person = person;
    }

}
