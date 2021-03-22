package org.datastructure.secondday.recursion;

import java.lang.reflect.Array;

public class Queen8 {
    private int max = 8;
    int[] array = new int[max];
    static int count = 0;

    public static void main(String[] args) {

        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.printf("一共有%d中组合方式",count);
    }

    public void check(int n) {
        if (n == max) {
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //todo array[n] == array[i] 通过遍历array【i】来对比每列只有一个棋子
            //todo n-i=每行距离，Math.abs(array[n]-array[i])每列的距离，当行和列相等时，就断定为对角线
            if (array[n] == array[i] || n - i == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    public void print() {
        count++;
        for (int i = 0; i < max; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
