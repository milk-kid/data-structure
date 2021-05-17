package org.datastructure.secondday.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {

    public static void main(String[] args) {
        int arr[] = {1, 4,};
       /* int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }*/

        Date t1 = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(t1));
        sort(arr);
        Date t2 = new Date();
        System.out.println(df.format(t2));
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int... arr) {

        int minIndex = 0, min;

        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (min != arr[i]) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}


