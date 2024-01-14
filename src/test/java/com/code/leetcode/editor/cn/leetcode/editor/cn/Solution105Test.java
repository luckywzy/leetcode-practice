package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution105Test {

    @Test
    public void buildTree() {
        TreeNode treeNode = new Solution105().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        List<List<Integer>> lists = new Solution102().levelOrder(treeNode);
        lists.forEach(l -> {
            l.forEach(k -> System.out.print(k + ","));
            System.out.println();
        });
    }
}