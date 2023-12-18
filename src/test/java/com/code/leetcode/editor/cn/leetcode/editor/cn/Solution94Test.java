package com.code.leetcode.editor.cn.leetcode.editor.cn;

import junit.framework.TestCase;

import java.util.List;

public class Solution94Test extends TestCase {

    public void testInorderTraversal() {
        List<Integer> integers = new Solution94().inorderTraversal(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null)));
        integers.forEach(System.out::println);
    }

    public void testInorderTraversal1() {
        List<Integer> integers = new Solution94().inorderTraversal(new TreeNode(1));
        integers.forEach(System.out::println);
    }
}