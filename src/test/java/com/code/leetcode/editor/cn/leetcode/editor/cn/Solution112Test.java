package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution112Test {

    @Test
    public void hasPathSum() {
        boolean hasPathSum = new Solution112().hasPathSum(new TreeNode(1, new TreeNode(2), new TreeNode(3)), 3);
        assertTrue(hasPathSum);
    }
    @Test
    public void hasPathSum2() {
        boolean hasPathSum = new Solution112().hasPathSum(new TreeNode(1, new TreeNode(2), new TreeNode(3)), 5);
        assertFalse(hasPathSum);
    }

    @Test
    public void hasPathSum3() {
        boolean hasPathSum = new Solution112().hasPathSum(new TreeNode(1, new TreeNode(2), null), 1);
        assertFalse(hasPathSum);
    }

    @Test
    public void hasPathSum1() {
        boolean hasPathSum = new Solution112().hasPathSum(
                new TreeNode(5,
                        new TreeNode(4,
                                new TreeNode(11,
                                        new TreeNode(7), new TreeNode(2)),
                                null),
                        new TreeNode(8,
                                new TreeNode(13), new TreeNode(4, null,new TreeNode(1)))), 22);
        assertTrue(hasPathSum);
    }
}