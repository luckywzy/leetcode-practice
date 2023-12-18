package com.code.leetcode.editor.cn.leetcode.editor.cn;

import junit.framework.TestCase;

import java.util.List;

public class Solution102Test extends TestCase {

    public void testLevelOrder() {
        List<List<Integer>> lists = new Solution102().levelOrder(new TreeNode(2, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(15))));
        lists.forEach(x -> {
            x.forEach(a -> {
                System.out.print(a + " \t");
            });
            System.out.println();
        });
    }
}