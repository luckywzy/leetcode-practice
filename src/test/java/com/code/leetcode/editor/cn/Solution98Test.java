package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2022/1/17 11:30 下午
 */
public class Solution98Test {

    @Test
    public void isValidBST() {
        Solution98 solution98 = new Solution98();

        Solution98.TreeNode treeNode = new Solution98.TreeNode(2,
                new Solution98.TreeNode(1),
                new Solution98.TreeNode(3));

        Assert.assertTrue(solution98.isValidBST(treeNode));
    }
}