package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/11/9 11:22 上午
 */
public class Solution285Test {

    @Test
    public void inorderSuccessor() {
        Solution285 solution285 = new Solution285();
        Solution285.TreeNode root = mockTree(new Integer[]{2, 1, 3});
        Solution285.TreeNode treeNode = solution285.inorderSuccessor(root, new Solution285.TreeNode(1));
        Assert.assertEquals(2, treeNode.val);
    }

    @Test
    public void inorderSuccessor2() {
        Solution285 solution285 = new Solution285();
        Solution285.TreeNode root = mockTree(new Integer[]{5,3,6,2,4,null,null,1});
        Solution285.TreeNode treeNode = solution285.inorderSuccessor(root, new Solution285.TreeNode(6));
        assertNull(treeNode);
    }

    @Test
    public void inorderSuccessor2_1() {
        Solution285 solution285 = new Solution285();
        Solution285.TreeNode root = mockTree(new Integer[]{2, 1, 3});
        Solution285.TreeNode treeNode = solution285.inorderSuccessor2(root, new Solution285.TreeNode(1));
        Assert.assertEquals(2, treeNode.val);
    }

    @Test
    public void inorderSuccessor2_2() {
        Solution285 solution285 = new Solution285();
        Solution285.TreeNode root = mockTree(new Integer[]{5,3,6,2,4,null,null,1});
        Solution285.TreeNode treeNode = solution285.inorderSuccessor2(root, new Solution285.TreeNode(6));
        assertNull(treeNode);
    }

    @Test
    public void inorderSuccessor2_3() {
        Solution285 solution285 = new Solution285();
        Solution285.TreeNode root = mockTree(new Integer[]{2,1});
        Solution285.TreeNode treeNode = solution285.inorderSuccessor2(root, new Solution285.TreeNode(2));
        assertNull(treeNode);
    }



    @Test
    public void inorderSuccessor3_1() {
        Solution285 solution285 = new Solution285();
        Solution285.TreeNode root = mockTree(new Integer[]{2, 1, 3});
        Solution285.TreeNode treeNode = solution285.inorderSuccessor3(root, new Solution285.TreeNode(1));
        Assert.assertEquals(2, treeNode.val);
    }

    @Test
    public void inorderSuccessor3_2() {
        Solution285 solution285 = new Solution285();
        Solution285.TreeNode root = mockTree(new Integer[]{5,3,6,2,4,null,null,1});
        Solution285.TreeNode treeNode = solution285.inorderSuccessor3(root, new Solution285.TreeNode(6));
        assertNull(treeNode);
    }

    @Test
    public void inorderSuccessor3_3() {
        Solution285 solution285 = new Solution285();
        Solution285.TreeNode root = mockTree(new Integer[]{2,1});
        Solution285.TreeNode treeNode = solution285.inorderSuccessor3(root, new Solution285.TreeNode(2));
        assertNull(treeNode);
    }



    Solution285.TreeNode mockTree(Integer[] vals) {
        Solution285.TreeNode treeNode = new Solution285.TreeNode();
        treeNode.val = vals[0];
        doMockTree(treeNode, vals, 1, vals.length - 1);

        return treeNode;
    }

    private void doMockTree(Solution285.TreeNode root, Integer[] vals, int l, int r) {
        if (l > r) {
            return;
        }
        Solution285.TreeNode treeNodeLeft = new Solution285.TreeNode();
        if (vals[l] != null) {
            treeNodeLeft.val = vals[l];
            root.left = treeNodeLeft;
        }
        Solution285.TreeNode treeNodeRight = new Solution285.TreeNode();
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