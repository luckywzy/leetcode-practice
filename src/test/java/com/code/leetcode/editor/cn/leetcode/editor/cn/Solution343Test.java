package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution343Test {

    @Test
    public void integerBreak() {
        assertEquals(1, new Solution343().integerBreak(2));
        assertEquals(4, new Solution343().integerBreak(4));
        assertEquals(36, new Solution343().integerBreak(10));
    }
}