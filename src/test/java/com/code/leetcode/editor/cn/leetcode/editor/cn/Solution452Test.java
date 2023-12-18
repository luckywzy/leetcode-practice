package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution452Test {

    @Test
    public void findMinArrowShots() {
        int minArrowShots = new Solution452().findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}});
        assertEquals(4, minArrowShots);
    }

    @Test
    public void findMinArrowShots_1() {
        int minArrowShots = new Solution452().findMinArrowShots(new int[][]{{10, 16}, {1, 6}, {2, 8}, {7, 12}});
        assertEquals(2, minArrowShots);
    }

    @Test
    public void findMinArrowShots_2() {
        int minArrowShots = new Solution452().findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}});
        assertEquals(2, minArrowShots);
    }
}