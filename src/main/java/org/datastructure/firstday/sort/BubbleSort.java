package org.datastructure.firstday.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {1, 4, 100, 2, -2};

        int temp;

        //TODO 元素相比次数=数组长度-1
        for (int i = 0; i < arr.length - 1; i++) {

            //todo arr.length-1 =倒数第二个元素，arr[j+1]刚好是最后一个元素
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
