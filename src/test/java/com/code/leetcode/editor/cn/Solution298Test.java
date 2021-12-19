package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/12/19 2:17 下午
 */
public class Solution298Test {

    @Test
    public void longestConsecutive() {

        Solution298 solution298 = new Solution298();

        Solution298.TreeNode treeNode = new Solution298.TreeNode(1,
                null,
                new Solution298.TreeNode(3,
                        new Solution298.TreeNode(2),
                        new Solution298.TreeNode(4,
                                null,
                                new Solution298.TreeNode(5))));

        int longestConsecutive = solution298.longestConsecutive(treeNode);
        Assert.assertEquals(3, longestConsecutive);
    }

    @Test
    public void longestConsecutive2() {

        Solution298 solution298 = new Solution298();

        Solution298.TreeNode treeNode = new Solution298.TreeNode(2,
                null,
                new Solution298.TreeNode(3,
                        new Solution298.TreeNode(2, new Solution298.TreeNode(1), null),
                        null));

        int longestConsecutive = solution298.longestConsecutive(treeNode);
        Assert.assertEquals(2, longestConsecutive);
    }

    @Test
    public void longestConsecutive3() {

        Solution298 solution298 = new Solution298();

        Solution298.TreeNode treeNode = new Solution298.TreeNode(2, null,
                new Solution298.TreeNode(3, null,
                        new Solution298.TreeNode(3, null,
                                new Solution298.TreeNode(4, null, new Solution298.TreeNode(5)))));

        int longestConsecutive = solution298.longestConsecutive(treeNode);
        Assert.assertEquals(3, longestConsecutive);
    }
}