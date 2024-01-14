package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution56Test {

    @Test
    public void merge() {
        // [[1,3],[2,6],[8,10],[15,18]]
        int[][] merge = new Solution56().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        for (int i = 0; i < merge.length; i++) {
            System.out.println("["+merge[i][0]+","+merge[i][1]+"]");
        }
    }

    @Test
    public void merge1() {
        // [[1,3],[2,6],[8,10],[15,18]]
        int[][] merge = new Solution56().merge(new int[][]{{1, 4}, {4, 5}});
        for (int i = 0; i < merge.length; i++) {
            System.out.println("["+merge[i][0]+","+merge[i][1]+"]");
        }
    }
}