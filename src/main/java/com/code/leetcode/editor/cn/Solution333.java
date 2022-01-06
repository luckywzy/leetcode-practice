package com.code.leetcode.editor.cn;

//给定一个二叉树，找到其中最大的二叉搜索树（BST）子树，并返回该子树的大小。其中，最大指的是子树节点数最多的。 
//
// 二叉搜索树（BST）中的所有节点都具备以下属性： 
//
// 
// 
// 左子树的值小于其父（根）节点的值。 
// 
// 
// 右子树的值大于其父（根）节点的值。 
// 
// 
//
// 注意: 
//
// 
// 子树必须包含其所有后代。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,15,1,8,null,7]
//输出：3
//解释：本例中最大的 BST 子树是高亮显示的子树。返回值是子树的大小，即 3 。 
//
// 示例 2： 
//
// 
//输入：root = [4,2,7,2,3,5,null,2,null,null,null,null,null,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 树上节点数目的范围是 [0, 10⁴] 
// -10⁴ <= Node.val <= 10⁴ 
// 
//
// 
//
// 进阶: 你能想出 O(n) 时间复杂度的解法吗？ 
// Related Topics 树 深度优先搜索 二叉搜索树 动态规划 二叉树 👍 119 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import static com.code.leetcode.editor.cn.Solution298.*;

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
class Solution333 {

    /**
     * 先判断是否是合法的BST，然后再累加数量
     * @param root
     * @return
     */
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return accCount(root);
        }
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    public boolean isBST(TreeNode root, int l, int r) {
        if (root == null) {
            return true;
        }
        if (root.val <= l || root.val >= r) {
            return false;
        }
        return isBST(root.left, l, root.val) && isBST(root.right, root.val, r);
    }

    private int accCount(TreeNode root) {
        return root == null ? 0 : 1 + accCount(root.left) + accCount(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
