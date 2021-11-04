package com.code.leetcode.editor.cn;

//给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。 
//
// 注意： 
//
// 
// 给定的目标值 target 是一个浮点数 
// 题目保证在该二叉搜索树中只会存在一个最接近目标值的数 
// 
//
// 示例： 
//
// 输入: root = [4,2,5,1,3]，目标值 target = 3.714286
//
//    4
//   / \
//  2   5
// / \
//1   3
//
//输出: 4
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二分查找 二叉树 👍 99 👎 0


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
class Solution270 {
    public int closestValue1(TreeNode root, double target) {
        return doClosestVal1(root, target);
    }

    public int doClosestVal1(TreeNode root, double target) {
        if(root == null){
            return Integer.MAX_VALUE;
        }

        double rootVal = abs(target, root.val);
        //left
        int valLeft = doClosestVal1(root.left, target);
        double absLeft = abs(target, valLeft);

        //right
        int valRight = doClosestVal1(root.right, target);
        double absRight = abs(target, valRight);

        return rootVal < absLeft ? rootVal < absRight ? root.val : valRight : valLeft;
    }

    double abs(double target, int val) {
        return Math.abs(target - Double.parseDouble(String.valueOf(val)));
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
