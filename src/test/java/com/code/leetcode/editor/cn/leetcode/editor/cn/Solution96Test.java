package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution96Test {

    @Test
    public void numTrees() {
        assertEquals(1, new Solution96().numTrees(0));
        assertEquals(1, new Solution96().numTrees(1));
        assertEquals(2, new Solution96().numTrees(2));
        assertEquals(5, new Solution96().numTrees(3));
        assertEquals(14, new Solution96().numTrees(4));
        assertEquals(42, new Solution96().numTrees(5));
    }
}