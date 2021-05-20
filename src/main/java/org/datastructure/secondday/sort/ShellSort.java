package org.datastructure.secondday.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {
    public static void main(String[] args) {
        //int arr[] = new int[]{8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        int arr[] = new int[800000];
        for (int i = 0; i < 800000; i++) {
            arr[i] = (int) (Math.random() * 80000000);
        }

        Date t1 = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(t1));
        // shellSort1(arr);
        shellSort2(arr);
        Date t2 = new Date();
        System.out.println(df.format(t2));
//        System.out.println(Arrays.toString(arr));

    }

    private static void shellSort1(int[] arr) {
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {

                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    private static void shellSort2(int[] arr) {

        int insertVal = 0;
        int insertIndex = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {
                insertVal = arr[i];
                insertIndex = i;
                if (arr[insertIndex] < arr[insertIndex - gap]) {
                    while (insertIndex - gap >= 0 && insertVal < arr[insertIndex - gap]) {
                        arr[insertIndex] = arr[insertIndex - gap];
                        insertIndex -= gap;
                    }

                    arr[insertIndex] = insertVal;
                }

            }
        }
    }
}
