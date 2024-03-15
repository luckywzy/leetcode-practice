package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution64Test {

    @Test
    public void minPathSum() {
        int minPathSum = new Solution64().minPathSum(new int[][]{
                {1, 3, 1}, {1, 5, 1}, {4, 2, 1}
        });
        assertEquals(7, minPathSum);
    }

    @Test
    public void minPathSum1() {
        int minPathSum = new Solution64().minPathSum(new int[][]{
                {1,2,3},{4,5,6}
        });
        assertEquals(12, minPathSum);
    }
    @Test
    public void minPathSum2() {
        int minPathSum = new Solution64().minPathSum(new int[][]{
                {1,2,3},
                {1,1,6}
        });
        assertEquals(9, minPathSum);
    }
}