package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution129Test {

    @Test
    public void sumNumbers() {
        assertEquals(25, new Solution129().sumNumbers(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
        assertEquals(1026, new Solution129().sumNumbers(new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0))));
        assertEquals(531, new Solution129().sumNumbers(new TreeNode(4, new TreeNode(9, null, new TreeNode(1)), new TreeNode(0))));
        assertEquals(535, new Solution129().sumNumbers(new TreeNode(4, new TreeNode(9, new TreeNode(5), null), new TreeNode(0))));
    }
}