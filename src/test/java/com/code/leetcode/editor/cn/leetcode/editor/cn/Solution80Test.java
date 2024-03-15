package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution80Test {

    @Test
    public void removeDuplicates() {
        assertEquals(5, new Solution80().removeDuplicates(new int[]{1,1,1,2,2,3}));
        assertEquals(7, new Solution80().removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }

    @Test
    public void removeDuplicates1() {
        //assertEquals(5, new Solution80().removeDuplicates1(new int[]{1,1,1,2,2,3}));
        assertEquals(7, new Solution80().removeDuplicates1(new int[]{0,0,1,1,1,1,2,3,3}));
    }
}