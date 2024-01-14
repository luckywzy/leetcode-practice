package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution98Test {

    @Test
    public void isValidBST() {
        assertEquals(true, new Solution98().isValidBST(new TreeNode(2, new TreeNode(1), new TreeNode(3))));
        assertEquals(false, new Solution98().isValidBST(new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)))));
    }
}