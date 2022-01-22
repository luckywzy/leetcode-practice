package com.code.leetcode.editor.cn;

//你需要用一个包括括号和整数的字符串构建一棵二叉树。 
//
// 输入的字符串代表一棵二叉树。它包括整数和随后的 0 、1 或 2 对括号。整数代表根的值，一对括号内表示同样结构的子树。 
//
// 若存在子结点，则从左子结点开始构建。 
//
// 
//
// 示例 1: 
//
// 
//输入： s = "4(2(3)(1))(6(5))"
//输出： [4,2,6,3,1,5]
// 
//
// 示例 2: 
//
// 
//输入： s = "4(2(3)(1))(6(5)(7))"
//输出： [4,2,6,3,1,5,7]
// 
//
// 示例 3: 
//
// 
//输入： s = "-4(2(3)(1))(6(5)(7))"
//输出： [-4,2,6,3,1,5,7]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// 输入字符串中只包含 '(', ')', '-' 和 '0' ~ '9' 
// 空树由 "" 而非"()"表示。 
// 
// Related Topics 树 深度优先搜索 字符串 二叉树 👍 74 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Stack;

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
class Solution536 {

    /**
     * 方法1：先找到第一个左括号的下标pos，循环遍历，使用pCnt 记录(出现的次数即 pCnt ++ ，当 ) 出现时，pCnt --;
     * 当 pCnt 等于0 时，左右括号匹配完成，说明已经找到一颗子树了，记录下第一个左括号出现的下标 start，和右括号出现的下标 i；
     * 但是如何区分左，右子树呢，通过下标区分，pos == start,说明是在构建左边的子数，如果不是则说明在右子树；
     *
     * @param s
     * @return
     */
    public TreeNode str2tree1(String s) {
        if (s == null || "".equals(s)) {
            return null;
        }

        return toTree(s);
    }

    public TreeNode toTree(String s) {
        int start;
        int pCnt = 0;
        int pos = s.indexOf("(");
        if (pos == -1) {
            return new TreeNode(Integer.parseInt(s));
        }
        start = pos;
        String val = s.substring(0, pos);
        TreeNode treeNode = new TreeNode(Integer.parseInt(val));
        for (int i = pos; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                pCnt++;
            } else if (s.charAt(i) == ')') {
                pCnt--;
            }

            if (pCnt == 0 && start == pos) {
                treeNode.left = toTree(s.substring(start + 1, i));
                start = i + 1;
            } else if (pCnt == 0 && start != pos) {
                treeNode.right = toTree(s.substring(start + 1, i));
            }
        }

        return treeNode;
    }


    /**
     * 方法2：可以使用栈来模拟递归
     * <p>
     * 遇见是数字则累加，否则
     *      1、累加的数字长度大于0了，生成一个节点保存到栈中
     *      2、遇见右括号了，将栈顶节点pop出来得到 node1，然后peek 栈顶节点 parent，此时
     *          parent.left == null，parent.left= node1,否则parent.right= node1
     * 预处理需要先把 root节点放到 栈中
     *
     * @param s
     * @return
     */
    public TreeNode str2tree(String s) {
        if (s.length() < 1) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        // 处理根节点
        int index = s.indexOf('(');
        if (index == -1) {
            return new TreeNode(Integer.parseInt(s));
        }
        TreeNode root = new TreeNode(Integer.parseInt(s.substring(0, index)));
        stack.push(root);
        StringBuilder num = new StringBuilder();
        for (int i = index + 1; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9' || s.charAt(i) == '-') {
                num.append(s.charAt(i));
                continue;
            }

            if (num.length() > 0) {
                TreeNode treeNode = new TreeNode(Integer.parseInt(num.toString()));
                stack.push(treeNode);
                num = new StringBuilder();
            }
            if (s.charAt(i) == ')') {
                TreeNode node = stack.pop();
                TreeNode parent = stack.peek();
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            }

        }

        return root;
    }


    public class TreeNode {
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
