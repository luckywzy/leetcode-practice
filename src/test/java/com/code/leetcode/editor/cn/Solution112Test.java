package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static com.code.leetcode.editor.cn.Solution112.*;
import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2022/1/12 11:12 下午
 */
public class Solution112Test {

    @Test
    public void hasPathSum() {
        Solution112 solution112 = new Solution112();
        TreeNode treeNode = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7),
                                new TreeNode(2)),
                        null),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4)));
        boolean hasPathSum = solution112.hasPathSum(treeNode, 22);
        assertTrue(hasPathSum);
    }
}