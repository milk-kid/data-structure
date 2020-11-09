package org.datastructure.secondday.qusparsearray;

/**
 * 稀疏矩阵
 * 1.遍历原矩阵，取出不同值的个数，以便创建稀疏矩阵列数时+1使用
 * 2.将原矩阵的行和列存入稀疏矩阵第一行的第一，二个元素，第三个位置存数组不同值的个数
 * 3.遍历原数组，将不同值存入稀疏矩阵，因为第一行已被占用需要创建临时变量代表行数
 * 4.稀疏数组的行用临时变量代替，第一，第二，第三个位置分布存入此时原数组的行，列，值
 * 5.恢复原数组时，使用稀疏数组的首行第一，第二个元素值创建
 * 6.遍历稀疏数组，将每行的第一个元素代表原数组的行，第二元素代表数组列，第三元素直接赋值给原数组以前两个元素值为坐标的元素
 */
public class SparseArray {

    public static void main(String[] args) {
        int arr[][] = new int[11][11];
        arr[1][4] = 1;
        arr[4][4] = 1;
        arr[6][0] = 1;

        System.out.println("原数据：");
        for (int[] a : arr) {
            for (int i : a) {
                System.out.printf("%d\t", i);
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
                    num++;
                }
            }
        }

        System.out.println("稀疏矩阵");
        for (int[] ints : sparseArray) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }

        System.out.println("恢复原数据");

        int recordArr[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            recordArr[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        for (int[] ints : recordArr) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
    }


}
