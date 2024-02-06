package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution700Test {

    @Test
    public void searchBST() {
        TreeNode treeNode = new Solution700().searchBST(
                new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7)),
                2
        );
        assertEquals(2, treeNode.val);
    }
}