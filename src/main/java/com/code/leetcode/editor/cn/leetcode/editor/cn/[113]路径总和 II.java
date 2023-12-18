package com.code.leetcode.editor.cn.leetcode.editor.cn;//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
//
// 叶子节点 是指没有子节点的节点。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics 树 深度优先搜索 回溯 二叉树 👍 1067 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.code.leetcode.editor.cn.leetcode.editor.cn.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        if (root == null){
            return result;
        }
        path.add(root.val);
        dfs(root,targetSum, root.val, path,result);
        return result;
    }

    void dfs(TreeNode node, int targetSum, int sum, List<Integer> path, List<List<Integer>> result) {
        if (node.left == null && node.right == null){
            if (sum == targetSum) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        if (node.left != null) {
            path.add(node.left.val);
            dfs(node.left, targetSum, sum + node.left.val, path, result);
            path.remove(path.size() - 1);
        }
        if (node.right != null) {
            path.add(node.right.val);
            dfs(node.right, targetSum, sum + node.right.val, path, result);
            path.remove(path.size() - 1);
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)
