package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/11/3 2:18 下午
 */
public class Solution270Test {

    @Test
    public void closestValue() {
        Solution270 solution270 = new Solution270();
        int closestValue = solution270.closestValue1(mockTree(new Integer[]{4, 2, 5, 1, 3}), 3.714286D);
        Assert.assertEquals(4, closestValue);
    }

    @Test
    public void closestValue1() {
        Solution270 solution270 = new Solution270();
        int closestValue = solution270.closestValue1(mockTree(new Integer[]{4, 2, 5, 1, 3}), 1.714286D);
        Assert.assertEquals(2, closestValue);
    }

    @Test
    public void closestValue2() {
        Solution270 solution270 = new Solution270();
        int closestValue = solution270.closestValue1(mockTree(new Integer[]{4, 2, 5, 1, 3}), 3.714286D);
        Assert.assertEquals(4, closestValue);
    }

    @Test
    public void closestValue3() {
        Solution270 solution270 = new Solution270();
        int closestValue = solution270.closestValue1(mockTree(new Integer[]{4, 2, 5, 1, 3}), 2.714286D);
        Assert.assertEquals(3, closestValue);
    }


    Solution270.TreeNode mockTree(Integer[] vals) {
        Solution270.TreeNode treeNode = new Solution270.TreeNode();
        treeNode.val = vals[0];
        doMockTree(treeNode, vals, 1, vals.length - 1);

        return treeNode;
    }

    private void doMockTree(Solution270.TreeNode root, Integer[] vals, int l, int r) {
        if (l > r) {
            return;
        }
        Solution270.TreeNode treeNodeLeft = new Solution270.TreeNode();
        if (vals[l] != null) {
            treeNodeLeft.val = vals[l];
            root.left = treeNodeLeft;
        }
        Solution270.TreeNode treeNodeRight = new Solution270.TreeNode();
        if (l + 1 <= r && vals[l + 1] != null) {
            treeNodeRight.val = vals[l + 1];
            root.right = treeNodeRight;
        }
        if (l + 2 <= r && vals[l + 2] != null) {
            doMockTree(treeNodeLeft, vals, l + 2, r);
        }
        if (l + 4 <= r && vals[l + 4] != null) {
            doMockTree(treeNodeRight, vals, l + 4, r);
        }
    }

}