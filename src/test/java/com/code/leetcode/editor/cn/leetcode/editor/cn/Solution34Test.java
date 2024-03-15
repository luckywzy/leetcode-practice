package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution34Test {

    @Test
    public void searchRange() {
        assertArrayEquals(new int[]{3, 4}, new Solution34().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
        assertArrayEquals(new int[]{-1, -1}, new Solution34().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
        assertArrayEquals(new int[]{-1, -1}, new Solution34().searchRange(new int[]{}, 6));
    }
}