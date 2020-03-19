package com.fesine.stack.practice;

/**
 * @description: 八皇后问题，使用递归实现
 * @author: Fesine
 * @createTime:2017/8/19 19:06
 * @update:修改内容
 * @author: Fesine
 * @updateTime:2017/8/19 19:06
 */
public class EightQueen {
    //统计总方案数
    static int count = 0;
    //皇后个数，同时也是棋盘行列总数
    static final int MAXQUEEN = 8;
    //定义cols数组，表示8列棋子摆放情况
    static int[] cols = new int[MAXQUEEN];

    public EightQueen() {
        getArrangement(0);
        System.out.println(MAXQUEEN + "皇后问题有" + count + "种摆放方法");
    }

    private void getArrangement(int n) {
        //遍历该列所有不合法的行，前用rows数组记录，不合法即rows[i]=true;
        boolean[] rows = new boolean[MAXQUEEN];
        for (int i = 0; i < n; i++) {
            rows[cols[i]] = true;
            int d = n - i;
            if (cols[i] - d >= 0)
                rows[cols[i] - d] = true;
            if (cols[i] + d <= MAXQUEEN - 1)
                rows[cols[i] + d] = true;
        }
        for (int i = 0; i < MAXQUEEN; i++) {
            if (rows[i])
                continue;
            cols[n] = i;
            if (n<MAXQUEEN-1)
                getArrangement(n+1);
            else {
                count++;
                printChessBoard();
            }
        }
    }

    private void printChessBoard() {
        System.out.println("第" + count + "种走法");
        for (int i = 0; i < MAXQUEEN; i++) {
            for (int j = 0; j < MAXQUEEN; j++) {
                if (i == cols[j]) {
                    System.out.print("0 ");
                } else {
                    System.out.print("+ ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new EightQueen();
    }


}
