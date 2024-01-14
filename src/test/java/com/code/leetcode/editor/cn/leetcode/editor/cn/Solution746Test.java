package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution746Test {

    @Test
    public void minCostClimbingStairs() {
        assertEquals(15, new Solution746().minCostClimbingStairs(new int[]{10,15,20}));
    }

    @Test
    public void minCostClimbingStairs1() {
        assertEquals(6, new Solution746().minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
}