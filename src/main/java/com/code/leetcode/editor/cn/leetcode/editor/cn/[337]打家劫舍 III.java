package com.code.leetcode.editor.cn.leetcode.editor.cn;
//小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为
// root 。 
//
// 除了
// root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的
//房子在同一天晚上被打劫 ，房屋将自动报警。 
//
// 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [3,2,3,null,3,null,1]
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7 
//
// 示例 2: 
//
// 
//
// 
//输入: root = [3,4,5,1,3,null,1]
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 树的节点数在 [1, 10⁴] 范围内 
// 0 <= Node.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1927 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

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
class Solution337 {
    public int rob(TreeNode root) {
        return rob_recordMap(root, new HashMap<>());
    }

    //暴力
    public int rob_rr(TreeNode root) {
        //考虑 偷父节点，那么两个子节点就不能偷
        //考虑，不偷父节点，那么两个子节点可以偷
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int sum1 = root.val;
        if (root.left != null) {
            sum1 += rob_rr(root.left.left) + rob_rr(root.left.right);
        }
        if (root.right != null) {
            sum1 += rob_rr(root.right.left) + rob_rr(root.right.right);
        }
        int sum2 = rob_rr(root.left) + rob_rr(root.right);
        return Math.max(sum1, sum2);
    }

    //记忆画搜索
    public int rob_recordMap(TreeNode root, Map<TreeNode, Integer> recordMap) {
        //考虑 偷父节点，那么两个子节点就不能偷
        //考虑，不偷父节点，那么两个子节点可以偷
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        if (recordMap.containsKey(root)) {
            return recordMap.get(root);
        }
        int sum1 = root.val;
        if (root.left != null) {
            sum1 += rob_recordMap(root.left.left, recordMap) + rob_recordMap(root.left.right, recordMap);
        }
        if (root.right != null) {
            sum1 += rob_recordMap(root.right.left, recordMap) + rob_recordMap(root.right.right, recordMap);
        }
        int sum2 = rob_recordMap(root.left, recordMap) + rob_recordMap(root.right, recordMap);

        recordMap.put(root, Math.max(sum1, sum2));
        return Math.max(sum1, sum2);
    }
    //TODO： 3.树形DP
}
//leetcode submit region end(Prohibit modification and deletion)
