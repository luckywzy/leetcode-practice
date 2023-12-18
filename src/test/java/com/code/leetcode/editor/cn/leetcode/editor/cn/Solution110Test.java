package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution110Test {

    @Test
    public void isBalanced() {
        boolean balanced = new Solution110().isBalanced(new TreeNode(1, new TreeNode(2), new TreeNode(3)));
        assertTrue(balanced);
    }
    @Test
    public void isBalanced2() {
        boolean balanced = new Solution110().isBalanced(new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5))));
        assertTrue(balanced);
    }
    @Test
    public void isBalanced3() {
        boolean balanced = new Solution110().isBalanced(new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(6), new TreeNode(7)), new TreeNode(5)), new TreeNode(3)));
        assertFalse(balanced);
    }

    @Test
    public void isBalanced4() {
        boolean balanced = new Solution110().isBalanced(new TreeNode(1, new TreeNode(2 ,new TreeNode(3,new TreeNode(4),new TreeNode(4)),new TreeNode(3)), new TreeNode(2, null, new TreeNode(2, null, new TreeNode(2)))));
        assertFalse(balanced);
    }
}