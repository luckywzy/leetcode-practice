package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution128Test {

    @Test
    public void longestConsecutive() {
        assertEquals(4,new Solution128().longestConsecutive(new int[]{100,4,200,1,3,2}));
        assertEquals(9,new Solution128().longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
}