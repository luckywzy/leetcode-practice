package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution654Test {

    @Test
    public void constructMaximumBinaryTree() {
        TreeNode treeNode = new Solution654().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        List<List<Integer>> lists = new Solution102().levelOrder(treeNode);
        lists.forEach(l ->{
            l.forEach(k-> System.out.print(k+","));
            System.out.println();
        });
    }

    @Test
    public void constructMaximumBinaryTree1() {
        TreeNode treeNode = new Solution654().constructMaximumBinaryTree(new int[]{3, 2, 1});
        List<List<Integer>> lists = new Solution102().levelOrder(treeNode);
        lists.forEach(l ->{
            l.forEach(k-> System.out.print(k+","));
            System.out.println();
        });
    }

    @Test
    public void constructMaximumBinaryTree2() {
        TreeNode treeNode = new Solution654().constructMaximumBinaryTree(new int[]{1, 2, 3});
        List<List<Integer>> lists = new Solution102().levelOrder(treeNode);
        lists.forEach(l ->{
            l.forEach(k-> System.out.print(k+","));
            System.out.println();
        });
    }
}