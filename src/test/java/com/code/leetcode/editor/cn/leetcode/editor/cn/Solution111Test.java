package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution111Test {

    @Test
    public void minDepth() {
        int minDepth = new Solution111().minDepth(new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4, new TreeNode(5), null), new TreeNode(6))));
        assertEquals(2, minDepth);
    }

    @Test
    public void minDepth1() {
        int minDepth = new Solution111().minDepth(new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4 ,null, new TreeNode(5))))));
        assertEquals(5, minDepth);
    }

    @Test
    public void minDepth2() {
        int minDepth = new Solution111().minDepth(new TreeNode(1, null, new TreeNode(2, new TreeNode(4), new TreeNode(3, new TreeNode(5), new TreeNode(6)))));
        assertEquals(3, minDepth);
    }
}