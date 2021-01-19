package org.datastructure.firstday.recursion;

public class Queen8 {

    int max = 8;
    int[] array = new int[max];
    static int count = 0;

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println(count);
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
            if (array[i] == array[n] || n - i == Math.abs(array[n] - array[i])) {
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
