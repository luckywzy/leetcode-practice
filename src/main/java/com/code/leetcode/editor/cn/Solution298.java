package com.code.leetcode.editor.cn;

//给你一棵指定的二叉树的根节点 root ，请你计算其中 最长连续序列路径 的长度。 
//
// 最长连续序列路径 是依次递增 1 的路径。该路径，可以是从某个初始节点到树中任意节点，通过「父 - 子」关系连接而产生的任意路径。且必须从父节点到子节点，
//反过来是不可以的。 
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,3,2,4,null,null,null,5]
//输出：3
//解释：当中，最长连续序列是 3-4-5 ，所以返回结果为 3 。
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,2,null,1]
//输出：2
//解释：当中，最长连续序列是 2-3 。注意，不是 3-2-1，所以返回 2 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 3 * 10⁴] 内 
// -3 * 10⁴ <= Node.val <= 3 * 10⁴ 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 78 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

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
class Solution298 {

    /**
     * 1、计算左子树的最长连续路径，
     * 2、计算右子树的最长连续路径，
     * 3、如果根节点 + 1 = 左子节点，则左子树最长连续性路径加1
     * 4、如果根节点 + 1 = 右子节点，则右子树最长连续性路径加1 ,这里有个问题就是 如果子节点和父节点的值是相同的，那么这个方法就不好使了
     * <p>
     * 所以需要改变一下记录的方式，用一个全局变量记录最长序列，在遍历的时候，
     * 需要记录下父节点，确认父节点+1 == 子节点时，最长子序列才加1，否则将已记录的连续子序列长度重置为1  ！！！
     *
     * @param root
     * @return
     */
    int maxLen = 0;

    public int longestConsecutive(TreeNode root) {
        dolongestConsecutive(root, null, 0);
        return maxLen;
    }

    private void dolongestConsecutive(TreeNode root, TreeNode p, Integer len) {
        if (root == null) {
            return;
        }

        if (p != null && p.val + 1 == root.val) {
            len++;
        } else {
            len = 1;
        }
        maxLen = maxLen < len ? len : maxLen;
        dolongestConsecutive(root.left, root, len);
        dolongestConsecutive(root.right, root, len);
    }


    public static class TreeNode {
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
//leetcode submit region end(Prohibit modification and deletion)
