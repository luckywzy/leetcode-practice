package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution322Test {

    @Test
    public void coinChange() {
        int coinChange = new Solution322().coinChange(new int[]{1, 2, 5}, 11);
        assertEquals(3, coinChange);
    }
    @Test
    public void coinChange1() {
        int coinChange = new Solution322().coinChange(new int[]{2}, 3);
        assertEquals(-1, coinChange);
    }
}