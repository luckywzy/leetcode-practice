package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution198Test {

    @Test
    public void rob() {
        assertEquals(4, new Solution198().rob(new int[]{1, 2, 3, 1}));
        assertEquals(12, new Solution198().rob(new int[]{2, 7, 9, 3, 1}));
        assertEquals(10, new Solution198().rob(new int[]{1, 2, 3, 4, 5, 4}));
    }
}