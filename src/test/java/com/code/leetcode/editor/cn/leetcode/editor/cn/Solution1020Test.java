package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution1020Test {

    @Test
    public void numEnclaves() {
        int numEnclaves = new Solution1020().numEnclaves(new int[][]{
                {0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}
        });
        assertEquals(3, numEnclaves);
    }

    @Test
    public void numEnclaves1() {
        int numEnclaves = new Solution1020().numEnclaves(new int[][]{
                {0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}
        });
        assertEquals(0, numEnclaves);
    }
}