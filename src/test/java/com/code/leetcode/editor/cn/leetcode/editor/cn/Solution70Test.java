package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution70Test {

    @Test
    public void climbStairs() {
        Solution70 solution70 = new Solution70();
        assertEquals(solution70.climbStairs(1), solution70.climbStairs_1(1));
        assertEquals(solution70.climbStairs(2), solution70.climbStairs_1(2));
        assertEquals(solution70.climbStairs(3), solution70.climbStairs_1(3));
        assertEquals(solution70.climbStairs(5), solution70.climbStairs_1(5));
        assertEquals(solution70.climbStairs(10), solution70.climbStairs_1(10));
    }
}