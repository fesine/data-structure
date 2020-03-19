package com.fesine.link;

/**
 * @description: person实体类
 * @author: Fesine
 * @createTime:2017/8/3 23:15
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2017/8/3 23:15
 */
public class Person {
    int personNo; //编号
    String name; //姓名
    int age; //年龄

    public Person(int personNo, String name, int age) {
        this.personNo = personNo;
        this.name = name;
        this.age = age;
    }

    public int getPersonNo() {
        return personNo;
    }

    public void setPersonNo(int personNo) {
        this.personNo = personNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personNo=" + personNo +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
