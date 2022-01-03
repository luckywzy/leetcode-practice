package com.code.leetcode.editor.cn;

//给你一个二叉树的根结点，返回其结点按 垂直方向（从上到下，逐列）遍历的结果。 
//
// 如果两个结点在同一行和列，那么顺序则为 从左到右。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[9],[3,15],[20],[7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [3,9,8,4,0,1,7]
//输出：[[4],[9],[3,0,1],[8],[7]]
// 
//
// 示例 3： 
//
// 
//输入：root = [3,9,8,4,0,1,7,null,null,null,2,5]
//输出：[[4],[9,5],[3,0,1],[8,2],[7]]
// 
//
// 示例 4： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 哈希表 二叉树 👍 140 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;
import java.util.stream.Collectors;

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
class Solution314 {
    /**
     * 层序遍历可解
     * 先序遍历很难解决，有val相同时，深度和垂直位置不同时，插入位置不确定的问题
     * @param root
     * @return
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        Deque<Integer> posQueue = new LinkedList<>();
        Map<Integer, List<Integer>> colMap = new HashMap<>();
        queue.add(root);
        posQueue.add(0);

        int minPos = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int pos = posQueue.poll();
            colMap.compute(pos, (key, oldVal) -> {
                if (oldVal == null) {
                    oldVal = new LinkedList<>();
                }
                oldVal.add(node.val);
                return oldVal;
            });

            if (node.left != null) {
                queue.offer(node.left);
                posQueue.offer(pos - 1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                posQueue.offer(pos + 1);
            }
            minPos = Math.min(minPos, pos);
        }

        for (int i = minPos; i < minPos + colMap.size(); i++) {
            res.add(colMap.get(i));
        }
        return res;
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
