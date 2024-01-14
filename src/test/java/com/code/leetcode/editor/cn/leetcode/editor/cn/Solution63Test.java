package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution63Test {

    @Test
    public void uniquePathsWithObstacles() {
        assertEquals(2, new Solution63().uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
        assertEquals(1, new Solution63().uniquePathsWithObstacles(new int[][]{{0,1},{0,0}}));
    }
}