package com.code.leetcode.editor.cn;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2022/1/19 8:25 下午
 */
public class Solution366Test {

    @Test
    public void findLeaves() {
        Solution366 solution366 = new Solution366();
        Solution366.TreeNode treeNode = new Solution366.TreeNode(1,
                new Solution366.TreeNode(2,
                        new Solution366.TreeNode(4),
                        new Solution366.TreeNode(5)),
                new Solution366.TreeNode(3));
        List<List<Integer>> leaves = solution366.findLeaves(treeNode);
        for (List<Integer> leaf : leaves) {
            leaf.forEach(System.out::print);
            System.out.println();
        }

    }
}