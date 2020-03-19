package com.fesine.array;

import java.util.Arrays;

/**
 * @description: 类描述
 * @author: Fesine
 * @createTime:2017/8/3 15:28
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2017/8/3 15:28
 */
public class OrderArray {
    private long[] a;
    private int nElems;

    public OrderArray(int max) {
        a = new long[max];
        nElems = 0;
    }


    public int size() {
        return nElems;
    }

    //排序查找，使用二分法查找
    public int find(long searchKey) {
        //起始位置
        int lowerBound = 0;
        //终止位置
        int upperBound = nElems - 1;
        //当前位置
        int curIn;
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            System.out.println("lower:" + lowerBound + ",upper:" + upperBound + ",cur:" + curIn);
            //正好相等
            if (a[curIn] == searchKey) {
                return curIn;
            } else if (lowerBound > upperBound) {//没有找到
                return nElems;
            } else {
                if (a[curIn] < searchKey) {
                    lowerBound = curIn + 1;//在大区间，起始位置在当前位置后一位
                } else
                    upperBound = curIn - 1;//在小区间，终止位置在当前位置的前一位
            }
        }
    }

    /**
     * 从小到大排序插入
     *
     * @param value
     */
    public void insert(long value) {

        //for (j = 0; j < nElems; j++) {
        //    if (a[j] > value) {
        //        break;
        //    }
        //}
        //for (int k = nElems; k > j; k--) {
        //    a[k] = a[k - 1];
        //}
        //a[j] = value;
        //nElems++;
        if(nElems==0){
            a[0]=value;
            nElems++;
            return;
        }
         if(value>a[nElems-1]){
            a[nElems] = value;
            nElems++;
            return;
        }
        //起始位置
        int lowerBound = 0;
        //终止位置
        int upperBound = nElems - 1;
        //当前位置
        int curIn;
        //使用二分法插入数据
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (lowerBound > upperBound) {
                for (int k = nElems; k > lowerBound; k--) {
                    a[k] = a[k - 1];
                }
                a[lowerBound] = value;
                nElems++;
                return;
            } else {
                if (a[curIn] < value) {
                    lowerBound = curIn + 1;//在大区间，起始位置在当前位置后一位
                } else
                    upperBound = curIn - 1;//在小区间，终止位置在当前位置的前一位
            }
        }


    }

    public boolean delete(long value) {
        int j = find(value);
        if (j == nElems) {
            return false;
        } else {
            for (int k = j; k < nElems; k++) {
                a[k] = a[k + 1];
            }
            nElems--;
            return true;
        }
    }

    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println();
    }

    /**
     * 将元素少的数组合并到元素多的数组中
     * @param a
     * @param b
     * @return
     */
    public OrderArray merge(OrderArray a, OrderArray b) {
        int i = a.nElems;
        int j = b.nElems;
        if (i < j) {
            this.merge(b, a);
        }
        OrderArray c = new OrderArray(i+j);
        //复制a到c中
        for (int k = 0; k < i; k++) {
            c.a[k] = a.a[k];
        }
        c.nElems = i;
        for (int l = 0;l<j;l++) {
            long value = b.a[l];
            if (value > c.a[c.nElems - 1]) {
                c.a[c.nElems] = value;
                c.nElems++;
            }
            else{
                //起始位置
                int lowerBound = 0;
                //终止位置
                int upperBound = c.nElems - 1;
                //当前位置
                int curIn;
                //使用二分法插入数据
                boolean flag = true;
                while (flag) {
                    curIn = (lowerBound + upperBound) / 2;
                    if (lowerBound > upperBound) {
                        for (int k = c.nElems; k > lowerBound; k--) {
                            c.a[k] = c.a[k - 1];
                        }
                        c.a[lowerBound] = value;
                        c.nElems++;
                        flag = false;
                    } else {
                        if (c.a[curIn] < value) {
                            lowerBound = curIn + 1;//在大区间，起始位置在当前位置后一位
                        } else
                            upperBound = curIn - 1;//在小区间，终止位置在当前位置的前一位
                    }
                }
            }
        }
            return c;
    }

    public static void main(String[] args) {
        OrderArray arr = new OrderArray(100);
        OrderArray brr = new OrderArray(100);
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(66);
        arr.insert(55);
        arr.insert(22);
        arr.insert(11);
        arr.insert(88);
        arr.insert(33);
        arr.insert(0);
        arr.insert(9);
        arr.display();
        System.out.println(arr.size());
        brr.insert(90);
        brr.insert(10);
        brr.insert(20);
        brr.insert(60);
        brr.insert(30);
        brr.insert(50);
        brr.display();
        System.out.println(brr.size());
        OrderArray c = arr.merge(brr, arr);
        System.out.println(Arrays.toString(c.a));
        //int searchKey = 56;
        //if (arr.find(searchKey) !=arr.size()) {
        //    System.out.println("找到值：" + searchKey);
        //} else System.out.println("没有找到值：" + searchKey);
        //arr.delete(33);
        //arr.delete(99);
        //arr.delete(55);
        //arr.display();
        //System.out.println(arr.size());
    }


}
