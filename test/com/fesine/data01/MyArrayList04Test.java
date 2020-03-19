package com.fesine.data01;

/**
 *
 * Created by Fesine on 2016/5/6.
 */
public class MyArrayList04Test {

    public static void main(String[] args) {
        MyArrayList04<String> list04 = new MyArrayList04();
        list04.add("hello");
        list04.add("world");
        list04.add("fesine");
        list04.add("pactera");
        System.out.println(list04.size());
        list04.add(0,"fbbank");
        System.out.println(list04.get(0));
    }
}
