package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution300Test {

    @Test
    public void lengthOfLIS() {
        assertEquals(4, new Solution300().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        assertEquals(1, new Solution300().lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
        assertEquals(4, new Solution300().lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
    }
}