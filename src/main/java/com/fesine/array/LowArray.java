package com.fesine.array;

/**
 * @description: 低级的array实现，所有的功能并没有被封装
 * @author: Fesine
 * @createTime:2017/8/3 14:19
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2017/8/3 14:19
 */
public class LowArray {

    private long[] a;

    /**
     * 构造器，构造指定大小的数组
     * @param size
     */
    public LowArray(int size) {
        a = new long[size];
    }

    public void setElem(int index, long value) {
        a[index] = value;
    }

    public long getElem(int index) {
        return a[index];
    }

    public static void main(String[] args) {
        LowArray arr = new LowArray(100);
        int nElems = 0;
        int j;
        arr.setElem(0,77);
        arr.setElem(1,99);
        arr.setElem(2,44);
        arr.setElem(3,66);
        arr.setElem(4,55);
        arr.setElem(5,22);
        arr.setElem(6,11);
        arr.setElem(7,88);
        arr.setElem(8,33);
        arr.setElem(9,0);
        nElems = 10;
        //输出所有值
        for (j = 0; j < nElems; j++) {
            System.out.print(arr.getElem(j)+" ");
        }
        System.out.println();
        //查询数组中是否包含26
        int searchKey = 26;
        for (j = 0; j < nElems; j++) {
            if (arr.getElem(j) == searchKey) {
                break;
            }
        }
        if (j == nElems) {
            System.out.println("没有找到对应的值:" + searchKey);
        } else {
            System.out.println("找到对应的值：" + searchKey);
        }
        //删除值为55的数
        for (j = 0; j < nElems; j++) {
            if (arr.getElem(j) == 55) {
                break;
            }
        }
        for (int k = j; k < nElems; k++) {
            //将后面的元素前移一个
            arr.setElem(k,arr.getElem(k+1));
        }
        nElems--;
        //输出所有值
        for (j = 0; j < nElems; j++) {
            System.out.print(arr.getElem(j) + " ");
        }
        System.out.println();
    }

}
