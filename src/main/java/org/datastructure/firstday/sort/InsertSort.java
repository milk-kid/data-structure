package org.datastructure.firstday.sort;

import java.util.Arrays;

/**
 * 分成一个有序的队列和一个无序队列，第一个元素未有序，从第二哥元素开始
 */
public class InsertSort {
    public static void main(String[] args) {
        int arr[] = {5, 4, 100, 2, -2};
        for (int i = 1; i < arr.length; i++) {
            int insertIndex = i - 1;//最右边开始比较所以是当前元素下标-1
            int insertVal = arr[i];

            //todo 当insertIndex >= 0 && insertVal < arr[insertIndex]时，说明没有找到位置
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            /**
             * insertIndex >= 0 && insertVal < arr[insertIndex] 不满足时，就是找到位置了，此时insertIndex通过+1，退回要插入的位置
             */

            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;

            }
            System.out.println(Arrays.toString(arr));
        }
    }

}
