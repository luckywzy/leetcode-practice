package com.code.leetcode.editor.cn;

import org.junit.Test;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/11/15 4:17 下午
 */
public class Solution286Test {

    @Test
    public void wallsAndGates() {
        int[][] rooms = new int[][]{
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}
        };

        Solution286 solution286 = new Solution286();

        solution286.wallsAndGates(rooms);

        for (int[] room : rooms) {
            for (int j = 0; j < rooms[0].length; j++) {
                System.out.print(room[j] + ",");
            }
            System.out.println("\n");
        }
    }
}