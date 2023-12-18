package com.code.leetcode.editor.cn.leetcode.editor.cn;//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,10⁴] 
// 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 547 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution513 {
    int maxDepth = 0;
    int result =  0 ;

    public int findBottomLeftValue(TreeNode root) {
        find(root,  1);
        return result;
    }
    void find(TreeNode node, int depth) {
        if (node.left == null && node.right == null){
            if (maxDepth< depth){
                maxDepth = depth;
                result = node.val;
            }
        }
        if (node.left != null) {
            find(node.left, depth + 1);
        }
        if (node.right != null) {
            find(node.right, depth + 1);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
