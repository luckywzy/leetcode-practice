package com.code.leetcode.editor.cn;

//给你一棵二叉树，请按以下要求的顺序收集它的全部节点： 
//
// 
// 依次从左到右，每次收集并删除所有的叶子节点 
// 重复如上过程直到整棵树为空 
// 
//
// 
//
// 示例: 
//
// 输入: [1,2,3,4,5]
//  
//       1
//         / \
//        2   3
//       / \     
//      4   5    
//
//输出: [[4,5,3],[2],[1]]
// 
//
// 
//
// 解释: 
//
// 1. 删除叶子节点 [4,5,3] ，得到如下树结构： 
//
//           1
//         / 
//        2          
// 
//
// 
//
// 2. 现在删去叶子节点 [2] ，得到如下树结构： 
//
//           1          
// 
//
// 
//
// 3. 现在删去叶子节点 [1] ，得到空树： 
//
//           []         
// 
// Related Topics 树 深度优先搜索 二叉树 👍 154 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;
import java.util.function.Function;

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
class Solution366 {

    /**
     * 方法2
     * 计算每个节点距离叶子节点的高度，然后把节点高度相同的收集起来，最后再排序即可
     *
     * @param root
     * @return
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        helper(root, map);
        return new ArrayList<>(map.values());
    }

    private int helper(TreeNode node, Map<Integer, List<Integer>> map) {
        if (node == null) {
            return 0;
        }
        int hl = helper(node.left, map);
        int hr = helper(node.right, map);
        int cur = Math.max(hl, hr) + 1;
        map.computeIfAbsent(cur, integer -> new LinkedList<>()).add(node.val);
        return cur;
    }


    /**
     * 方法1：
     * 使用前序遍历的方式，通过不停的剪掉叶子节点，达到最终整棵树为空
     * 遇到叶子节点，则将其加入list，同时让其父节点的left，right指针指向 null；
     * 递归这个过程，直到整棵树为空
     *
     * @param root
     * @return
     */
    public List<List<Integer>> findLeaves1(TreeNode root) {
        List<List<Integer>> resList = new LinkedList<>();
        while (root != null) {
            ArrayList<Integer> list = new ArrayList<>();
            root = recur(root, list);
            resList.add(list);
        }
        return resList;
    }

    private TreeNode recur(TreeNode node, ArrayList<Integer> list) {
        if (node == null) {
            return null;
        }
        if (node.left == null && node.right == null) {
            list.add(node.val);
            return null;
        }
        node.left = recur(node.left, list);
        node.right = recur(node.right, list);
        return node;
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
