package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution222Test {

    @Test
    public void countNodes() {
        int countNodes = new Solution222().countNodes(new TreeNode(1, new TreeNode(2), new TreeNode(3)));
        assertEquals(3, countNodes);
    }

    @Test
    public void countNodes1() {
        int countNodes = new Solution222().countNodes(new TreeNode(1));
        assertEquals(1, countNodes);
    }

    @Test
    public void countNodes2() {
        int countNodes = new Solution222().countNodes(null);
        assertEquals(0, countNodes);
    }

    @Test
    public void countNodes3() {
        int countNodes = new Solution222().countNodes(new TreeNode(1, new TreeNode(2,new TreeNode(4), null), new TreeNode(3)));
        assertEquals(4, countNodes);
    }

    @Test
    public void countNodes4() {
        int countNodes = new Solution222().countNodes(new TreeNode(1, new TreeNode(2,new TreeNode(4), new TreeNode(5)), new TreeNode(3)));
        assertEquals(5, countNodes);
    }
}