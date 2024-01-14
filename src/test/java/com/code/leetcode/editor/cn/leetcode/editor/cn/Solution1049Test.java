package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution1049Test {

    @Test
    public void lastStoneWeightII() {
        Solution1049 solution1049 = new Solution1049();
        assertEquals(1, solution1049.lastStoneWeightII(new int[]{2,7,4,1,8,1}));
        assertEquals(5, solution1049.lastStoneWeightII(new int[]{31,26,33,21,40}));
        assertEquals(0, solution1049.lastStoneWeightII(new int[]{2,1,4,1}));
    }
}