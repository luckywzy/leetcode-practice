package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution416Test {

    @Test
    public void canPartition() {
        Solution416 solution416 = new Solution416();
        assertTrue(solution416.canPartition(new int[]{1, 5, 11, 5}));
        assertTrue(solution416.canPartition_1(new int[]{1, 5, 11, 5}));
        assertFalse(solution416.canPartition(new int[]{1, 3, 2, 5}));
        assertFalse(solution416.canPartition_1(new int[]{1, 3, 2, 5}));
    }
}