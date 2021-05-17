package org.datastructure.firstday.sort;


import java.text.SimpleDateFormat;
import java.util.*;

public class BubbleSort {
    public static void main(String[] args) {
        //int arr[] = {1, 4, 100, 2, -2};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }

        Date t1 = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(t1));
        sort(arr);
        Date t2 = new Date();
        System.out.println(df.format(t2));
    }

    private static void sort(int[] arr) {
        int temp;
        //TODO 元素相比次数=数组长度-1

        Boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            //todo arr.length-1 =倒数第二个元素，arr[j+1]刚好是最后一个元素
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }


}
