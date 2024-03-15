package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution581Test {

    @Test
    public void findUnsortedSubarray() {
        assertEquals(5, new Solution581().findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        assertEquals(6, new Solution581().findUnsortedSubarray(new int[]{2, 6, 1, 8, 10, 9, 15}));
    }
}