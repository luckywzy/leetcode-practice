package com.code.leetcode.editor.cn.leetcode.editor.cn;

import junit.framework.TestCase;
import org.junit.Assert;

public class Solution104Test extends TestCase {

    public void testMaxDepth() {
        Assert.assertEquals(3, new Solution104().maxDepth(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null))));
        Assert.assertEquals(3, new Solution104().maxDepth(new TreeNode(1, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
        Assert.assertEquals(2, new Solution104().maxDepth(new TreeNode(1, null, new TreeNode(20))));
        Assert.assertEquals(1, new Solution104().maxDepth(new TreeNode(1)));
    }
}