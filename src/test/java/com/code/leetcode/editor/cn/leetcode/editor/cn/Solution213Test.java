package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution213Test {

    @Test
    public void rob() {
        assertEquals(3, new Solution213().rob(new int[]{2, 3, 2}));
        assertEquals(4, new Solution213().rob(new int[]{1,2,3,1}));
    }
}