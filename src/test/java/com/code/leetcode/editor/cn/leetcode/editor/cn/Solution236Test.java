package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution236Test {

    @Test
    public void lowestCommonAncestor() {
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(3);
        TreeNode root = new TreeNode(1, p, q);
        assertEquals(root, new Solution236().lowestCommonAncestor(root, p, q));
    }
}