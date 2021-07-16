package com.code.leetcode.editor.cn;

//给定一个整数数组，你需要验证它是否是一个二叉搜索树正确的先序遍历序列。
//
// 你可以假定该序列中的数都是不相同的。 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [5,2,6,1,3]
//输出: false 
//
// 示例 2： 
//
// 输入: [5,2,1,3,6]
//输出: true 
//
// 进阶挑战： 
//
// 您能否使用恒定的空间复杂度来完成此题？ 
// Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 
// 👍 106 👎 0


import java.util.ArrayDeque;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution255 {
    /**
     * 知识点：二叉搜索树
     * 先序遍历: root -> left -> right
     * 值的特点是：right > root > left，所以右子树的节点都需要比当前节点大，如果有节点小于当前节点，那么返回false
     *
     * @param preorder
     * @return
     */
    public boolean verifyPreorder(int[] preorder) {
        Deque<Integer> stack = new ArrayDeque<>();
        int pre = Integer.MIN_VALUE;
        for (int j : preorder) {
            if (j < pre) {
                return false;
            }

            while (!stack.isEmpty() && stack.peek() < j) {
                pre = stack.pop();
            }

            stack.push(j);
        }
        return true;
    }

    /**
     * 暴力搜索，当找到一个节点的值大于当前节点时，其右边的节点必须要全部大于此节点才能满足搜索二叉树
     *
     * @param preorder
     * @return
     */
    public boolean verifyPreorder1(int[] preorder) {
        for (int i = 0; i < preorder.length; i++) {
            int j = i + 1;
            boolean hasBigger = false;
            for (; j < preorder.length; j++) {
                if (hasBigger && preorder[i] > preorder[j]) {
                    return false;
                }
                if (preorder[i] < preorder[j]) {
                    hasBigger = true;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
