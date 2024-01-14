package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution62Test {

    @Test
    public void uniquePaths() {
        assertEquals(28, new Solution62().uniquePaths(3,7));
        assertEquals(3, new Solution62().uniquePaths(3,2));
        assertEquals(6, new Solution62().uniquePaths(3,3));
    }
}