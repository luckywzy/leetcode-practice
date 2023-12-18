package com.code.leetcode.editor.cn.leetcode.editor.cn;//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 10⁵] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1132 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.code.leetcode.editor.cn.leetcode.editor.cn.TreeNode;

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
class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        int lmin = minDepth(root.left);
        int rmin = minDepth(root.right);

        if (root.left == null || root.right == null){
            return lmin + rmin + 1;
        }
        return Math.min(lmin, rmin)+1;
    }

    int doDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ldepth = minDepth(root.left) + 1;
        int rdepth = minDepth(root.right) + 1;
        return Math.min(ldepth, rdepth);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
