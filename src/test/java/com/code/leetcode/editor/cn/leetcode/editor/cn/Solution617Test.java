package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution617Test {

    @Test
    public void mergeTrees() {
        TreeNode treeNode = new Solution617().mergeTrees(
                new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2)),
                new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)))
        );
        List<List<Integer>> lists = new Solution102().levelOrder(treeNode);
        lists.forEach(l ->{
            l.forEach(k-> System.out.print(k+","));
            System.out.println();
        });
    }
}