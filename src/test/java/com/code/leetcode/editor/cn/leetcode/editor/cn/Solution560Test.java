package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution560Test {

    @Test
    public void subarraySum() {
        assertEquals(2, new Solution560().subarraySum(new int[]{1,1,1}, 2));
        assertEquals(2, new Solution560().subarraySum(new int[]{1,2,3}, 3));
        assertEquals(1, new Solution560().subarraySum(new int[]{1,-2,3}, 3));
    }

    @Test
    public void subarraySum1() {
        assertEquals(2, new Solution560().subarraySum1(new int[]{1,1,1}, 2));
        assertEquals(2, new Solution560().subarraySum1(new int[]{1,2,3}, 3));
        assertEquals(1, new Solution560().subarraySum1(new int[]{1,-2,3}, 3));
    }
}