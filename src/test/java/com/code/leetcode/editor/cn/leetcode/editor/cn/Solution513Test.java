package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution513Test {

    @Test
    public void findBottomLeftValue() {
        int bottomLeftValue = new Solution513().findBottomLeftValue(new TreeNode(2, new TreeNode(1), new TreeNode(3)));
        assertEquals(1, bottomLeftValue);
    }

    @Test
    public void findBottomLeftValue2() {
        int bottomLeftValue = new Solution513().findBottomLeftValue(new TreeNode(1));
        assertEquals(1, bottomLeftValue);
    }

    @Test
    public void findBottomLeftValue1() {
        int bottomLeftValue = new Solution513().findBottomLeftValue(
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4), null),
                        new TreeNode(3,
                                new TreeNode(5, new TreeNode(7), null),
                                new TreeNode(6))));
        assertEquals(7, bottomLeftValue);
    }
}