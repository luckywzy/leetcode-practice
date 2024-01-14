package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution494Test {

    @Test
    public void findTargetSumWays_backTrace() {
        Solution494 solution494 = new Solution494();
        assertEquals(5, solution494.findTargetSumWays_backTrace(new int[]{1,1,1,1,1},3));
    }

    @Test
    public void findTargetSumWays_backTrace_1() {
        Solution494 solution494 = new Solution494();
        assertEquals(1, solution494.findTargetSumWays_backTrace(new int[]{1},1));
    }

    @Test
    public void findTargetSumWays_1() {
        Solution494 solution494 = new Solution494();
        assertEquals(5, solution494.findTargetSumWays(new int[]{1,1,1,1,1},3));
    }

    @Test
    public void findTargetSumWays_2() {
        Solution494 solution494 = new Solution494();
        assertEquals(1, solution494.findTargetSumWays(new int[]{1},1));
    }
}