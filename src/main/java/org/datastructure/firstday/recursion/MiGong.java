package org.datastructure.firstday.recursion;

import java.util.HashMap;
import java.util.Map;

public class MiGong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * @param map
     * @param i
     * @param j
     * @return
     */
    public static boolean getWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i + 1][j] == 0) {
                map[i][j] = 2;
                if (getWay(map, i + 1, j)) {
                    return true;
                }else if()
            }
        }
        return true;
    }
}
