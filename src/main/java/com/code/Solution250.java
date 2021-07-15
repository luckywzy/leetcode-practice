package com.code;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution250 {
    /**
     * https://leetcode-cn.com/problems/count-univalue-subtrees/
     *  通过后序遍历，如果左节点 + 右节点 + 当前节点相等，数量加1；返回上一层
     * @param root
     * @return
     */
    public int countUnivalSubtrees(TreeNode root) {
        doCnt(root);

        return cnt;
    }

    public boolean doCnt(TreeNode node) {
        if (node == null) {
            return true;
        }
        boolean l = doCnt(node.left);
        boolean r = doCnt(node.right);

        boolean current = true;

        if ((node.left != null && node.val != node.left.val)
                || (node.right != null && node.val != node.right.val)) {
            current = false;
        }
        if(l && r && current){
            cnt++;
        }

        return l&& r && current;
    }

    private Integer cnt = 0;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}