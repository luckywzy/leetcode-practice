package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution1005Test {

    @Test
    public void largestSumAfterKNegations() {
        int sumAfterKNegations = new Solution1005().largestSumAfterKNegations(new int[]{4, 2, 3}, 1);
        assertEquals(5, sumAfterKNegations);
    }

    @Test
    public void largestSumAfterKNegations_1() {
        int sumAfterKNegations = new Solution1005().largestSumAfterKNegations(new int[]{3,-1,0,2}, 2);
        assertEquals(6, sumAfterKNegations);
    }
    @Test
    public void largestSumAfterKNegations_2() {
        int sumAfterKNegations = new Solution1005().largestSumAfterKNegations(new int[]{2,-3,-1,5,-4}, 2);
        assertEquals(13, sumAfterKNegations);
    }
}