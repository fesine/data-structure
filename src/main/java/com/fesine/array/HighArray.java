package com.fesine.array;

/**
 * @description: 在低级实现的基础上进行重构
 * @author: Fesine
 * @createTime:2017/8/3 14:44
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2017/8/3 14:44
 */
public class HighArray {
    private long[] a;
    private int nElems;

    public HighArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public boolean find(long searchKey) {
        int j = getIndex(searchKey);
        if (j == nElems) {
            return false;
        } else return true;
    }


    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public boolean delete(long value) {
        int j = getIndex(value);
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

    public int getIndex(long searchKey) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] == searchKey) {
                break;
            }
        }
        return j;
    }

    public long getMax() {
        if (nElems == 0) {
            return -1;
        }
        long tmp = a[0];
        for (int i = 1; i < nElems; i++) {
            if (tmp < a[i]) {
                tmp = a[i];
            }
        }
        return tmp;
    }

    public void removeMax() {
        if (nElems == 0) {
            return;
        }
        long tmp = a[0];
        int j=0;
        for (int i = 1; i < nElems; i++) {
            if (tmp < a[i]) {
                tmp = a[i];
                j=i;
            }
        }
        for (int k = j; k < nElems; k++) {
            a[k] = a[k + 1];
        }
        nElems--;
    }

    /**
     * 去除数组中重复的数据
     */
    public void noDup(){
        for (int i = 0; i < nElems; i++) {
            long tmp = a[i];
            for (int j = i+1; j < nElems; j++) {
                if (a[j] == tmp){
                    for (int k = j; k < nElems; k++) {
                        a[k] = a[k + 1];
                    }
                    nElems--;
                }
            }
        }

    }

    public static void main(String[] args) {
        HighArray arr = new HighArray(100);
        arr.insert(77);
        arr.insert(99);
        arr.insert(88);
        arr.insert(44);
        arr.insert(66);
        arr.insert(55);
        arr.insert(77);
        arr.insert(22);
        arr.insert(11);
        arr.insert(88);
        arr.insert(77);
        arr.insert(33);
        arr.insert(0);
        arr.insert(9);
        arr.display();
        System.out.println(arr.size());
        System.out.println(arr.getMax());
        int searchKey = 55;
        if (arr.find(searchKey)) {
            System.out.println("找到值：" + searchKey);
        } else System.out.println("没有找到值：" + searchKey);
        //arr.delete(33);
        //arr.delete(99);
        //arr.delete(55);
        //arr.removeMax();
        arr.noDup();
        arr.display();
        System.out.println(arr.size());
    }

}
