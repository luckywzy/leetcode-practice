package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution518Test {

    @Test
    public void change() {
        assertEquals(4, new Solution518().change(5, new int[]{1, 2, 5}));
        assertEquals(1, new Solution518().change(10, new int[]{10}));
        assertEquals(0, new Solution518().change(3, new int[]{2}));
    }
}