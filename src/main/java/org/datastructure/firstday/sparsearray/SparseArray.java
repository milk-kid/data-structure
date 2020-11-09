package org.datastructure.firstday.sparsearray;

/**
 * 稀疏矩阵
 */
public class SparseArray {

    public static void main(String[] args) {

        System.out.println("原数组");
        int arr[][] = new int[11][11];
        arr[1][2] = 1;
        arr[3][3] = 1;
        arr[3][2] = 10;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.printf("\t%d", anInt);
            }
            System.out.println();
        }

        int count = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    count++;
                }
            }
        }

        //将数组转化成稀疏矩阵
        int sparseArray[][] = new int[count + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = count;
        int num = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    sparseArray[num][0] = i;
                    sparseArray[num][1] = j;
                    sparseArray[num][2] = arr[i][j];
                    ++num;
                }
            }
        }

        //输出稀疏数组
        System.out.println("稀疏矩阵");
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t", sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
            System.out.println();
        }


        //将稀疏矩阵恢复成二维数组
        int recoverArray[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
                recoverArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        //输出恢复后的数据
        System.out.println("恢复后的数据");
        for (int[] ints : recoverArray) {
            for (int anInt : ints) {
                System.out.printf("\t%d", anInt);
            }
            System.out.println();
        }
    }


}
