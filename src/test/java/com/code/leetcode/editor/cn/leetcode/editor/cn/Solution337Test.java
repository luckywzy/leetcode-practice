package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution337Test {

    @Test
    public void rob() {
        assertEquals(7, new Solution337().rob(new TreeNode(3,
                new TreeNode(2, null, new TreeNode(3)), new TreeNode(3, null, new TreeNode(1)))));

        assertEquals(9, new Solution337().rob(new TreeNode(3,
                new TreeNode(4, new TreeNode(1), new TreeNode(3)), new TreeNode(5, null, new TreeNode(1)))));
    }
}