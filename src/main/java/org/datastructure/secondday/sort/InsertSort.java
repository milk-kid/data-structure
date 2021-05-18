package org.datastructure.secondday.sort;

import java.util.Arrays;

public class InsertSort {


    public static void main(String[] args) {

        int[] arr = new int[]{3, 77, 1, 32, 0};
        for (int i = 1; i < arr.length; i++) {

            int insertIndex = i - 1;
            int insertVal = arr[i];


            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {

                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i)
                arr[insertIndex + 1] = insertVal;
        }

        System.out.println(Arrays.toString(arr));
    }

}
