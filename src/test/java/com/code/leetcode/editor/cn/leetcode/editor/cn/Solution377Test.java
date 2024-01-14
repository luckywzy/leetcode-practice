package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution377Test {

    @Test
    public void combinationSum4() {
        int sum4 = new Solution377().combinationSum4(new int[]{1, 2, 3}, 4);
        assertEquals(7, sum4);
    }


    @Test
    public void combinationSum4_1() {
        int sum4 = new Solution377().combinationSum4(new int[]{9}, 3);
        assertEquals(0, sum4);
    }

    @Test
    public void combinationSum4_2() {
        int sum4 = new Solution377().combinationSum4(new int[]{1,3,5}, 6);
        assertEquals(8, sum4);
    }
}