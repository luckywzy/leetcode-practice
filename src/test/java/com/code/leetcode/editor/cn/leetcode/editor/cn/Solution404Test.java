package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution404Test {

    @Test
    public void sumOfLeftLeaves() {
        int sum = new Solution404().sumOfLeftLeaves(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))));
        assertEquals(24, sum);
    }

    @Test
    public void sumOfLeftLeaves1() {
        int sum = new Solution404().sumOfLeftLeaves(new TreeNode(1));
        assertEquals(0, sum);
    }

    @Test
    public void sumOfLeftLeaves2() {
        int sum = new Solution404().sumOfLeftLeaves(new TreeNode(1, null, new TreeNode(2)));
        assertEquals(0, sum);
    }

    @Test
    public void sumOfLeftLeaves3() {
        int sum = new Solution404().sumOfLeftLeaves(new TreeNode(3, new TreeNode(9, new TreeNode(6), new TreeNode(7)),
                                                                         new TreeNode(20, new TreeNode(15), new TreeNode(7))));
        assertEquals(21, sum);
    }
}