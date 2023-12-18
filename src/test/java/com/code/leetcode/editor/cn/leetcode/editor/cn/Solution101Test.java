package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution101Test {

    @Test
    public void isSymmetric() {
        boolean symmetric = new Solution101().isSymmetric(new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3))));
        assertTrue(symmetric);
    }
    @Test
    public void isSymmetric1() {
        boolean symmetric = new Solution101().isSymmetric(new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(2, null, new TreeNode(4))));
        assertFalse(symmetric);
    }
    @Test
    public void isSymmetric2() {
        boolean symmetric = new Solution101().isSymmetric(new TreeNode(1));
        assertTrue(symmetric);
    }
}