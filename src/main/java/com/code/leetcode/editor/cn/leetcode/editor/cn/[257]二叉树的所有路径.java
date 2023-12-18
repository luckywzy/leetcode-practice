package com.code.leetcode.editor.cn.leetcode.editor.cn;//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
//
// 叶子节点 是指没有子节点的节点。 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 1073 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
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
class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        path(root, paths, new ArrayList<>());
        return paths;
    }


    public void path(TreeNode root, List<String> result, List<Integer> p) {
        p.add(root.val);
        if (root.right == null && root.left == null) {
            result.add(p.stream().map(Object::toString).collect(Collectors.joining("->")));
        }
        if (root.left != null) {
            path(root.left, result, p);
        }
        if (root.right != null) {
            path(root.right, result, p);
        }
        p.remove(p.size() - 1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
