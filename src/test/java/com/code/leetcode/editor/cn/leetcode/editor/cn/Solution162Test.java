package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution162Test {

    @Test
    public void findPeakElement() {
        assertEquals(2, new Solution162().findPeakElement(new int[]{1,2,3,1}));
        assertEquals(5, new Solution162().findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
}