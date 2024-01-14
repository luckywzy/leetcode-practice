package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution221Test {

    @Test
    public void maximalSquare() {
        assertEquals(4, new Solution221().maximalSquare(
                new char[][]{
                        {'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'},
                }));

        assertEquals(9, new Solution221().maximalSquare(
                new char[][]{
                        {'0', '1', '1', '1', '0'},
                        {'1', '1', '1', '1', '0'},
                        {'0', '1', '1', '1', '1'},
                        {'0', '1', '1', '1', '1'},
                        {'0', '0', '1', '1', '1'},
                }));
    }
}