package org.datastructure.firstday.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShellSort {

    public static void main(String[] args) {
         //int arr[] = new int[]{8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

        int arr[] = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 1000000);
        }

        Date t1 = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(t1));
//        shellSort1(arr);
        shellSort2(arr);
        Date t2 = new Date();
        System.out.println(df.format(t2));


    }

    /**
     * 交换排序，不是最优的性能
     *
     * @param arr
     */
    private static void shellSort1(int[] arr) {
        for (int step = arr.length / 2; step > 0; step /= 2) {

            int temp = 0;
            for (int i = step; i < arr.length; i++) {
                //TODO 从高下标到低下标，交换排序多次，step个序列同时插入排序，
                for (int j = i - step; j >= 0; j -= step) {

                    if (arr[j] > arr[j + step]) {
                        temp = arr[j + step];
                        arr[j + step] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
//
         /*   for (int i = 2; i < arr.length; i++) {
            for (int j = i - 2; j >= 0; j -= 2) {

                if (arr[j] > arr[j+2]) {
                    temp = arr[j+2];
                    arr[j+2] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));*/
    }

    /**
     * 交换排序，也是插入排序，只是要找到位置后只插入一次
     *
     * @param arr
     */
    public static void shellSort2(int... arr) {
        int j = 0;
        int temp = 0;
        for (int step = arr.length / 2; step > 0; step /= 2) {

            for (int i = step; i < arr.length; i++) {

                j = i;
                temp = arr[i];
                //todo 如果不满足第一次比较那么之后的比较不再进行，起始影响不大
                if (arr[j] < arr[j - step]) {
                    while (j - step >= 0 && temp < arr[j - step]) {
                        arr[j] = arr[j - step];//todo 将比较后小的元素复制到后一个元素位置
                        j -= step;//todo 这时才指向较小元素的位置，如果不满足继续循环的条件，那么元素插入位置就是该位置
                    }
                    arr[j] = temp;

                }

            }
           // System.out.println(Arrays.toString(arr));
        }
    }
}
