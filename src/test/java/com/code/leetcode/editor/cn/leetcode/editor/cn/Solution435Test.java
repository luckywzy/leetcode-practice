package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution435Test {

    @Test
    public void eraseOverlapIntervals() {
        int intervals = new Solution435().eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}});
        assertEquals(2, intervals);
    }

    @Test
    public void eraseOverlapIntervals_1() {
        int intervals = new Solution435().eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4},{1,3}});
        assertEquals(1, intervals);
    }

    @Test
    public void eraseOverlapIntervals_2() {
        int intervals = new Solution435().eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}});
        assertEquals(0, intervals);
    }
}