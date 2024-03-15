package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution152Test {

    @Test
    public void maxProduct() {
        assertEquals(6, new Solution152().maxProduct(new int[]{2,3,-2,4}));
        assertEquals(0, new Solution152().maxProduct(new int[]{-2,0,-1}));
        assertEquals(2, new Solution152().maxProduct(new int[]{-2,-1}));
        assertEquals(3, new Solution152().maxProduct(new int[]{-2,-1,-3}));
        assertEquals(24, new Solution152().maxProduct(new int[]{-2,-1,-3,-4}));
    }
}