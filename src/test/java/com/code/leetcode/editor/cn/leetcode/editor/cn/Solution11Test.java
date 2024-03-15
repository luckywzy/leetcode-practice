package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution11Test {

    @Test
    public void maxArea() {
        assertEquals(49,new Solution11().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        assertEquals(1,new Solution11().maxArea(new int[]{1,1}));
        assertEquals(16,new Solution11().maxArea(new int[]{1,8,1,8}));
    }
}