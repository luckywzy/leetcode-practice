package com.code.leetcode.editor.cn;

//给定一棵二叉搜索树和其中的一个节点 p ，找到该节点在树中的中序后继。如果节点没有中序后继，请返回 null 。 
//
// 节点 p 的后继是值比 p.val 大的节点中键值最小的节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [2,1,3], p = 1
//输出：2
//解释：这里 1 的中序后继是 2。请注意 p 和返回值都应是 TreeNode 类型。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [5,3,6,2,4,null,null,1], p = 6
//输出：null
//解释：因为给出的节点没有中序后继，所以答案就返回 null 了。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 10⁴] 内。 
// -10⁵ <= Node.val <= 10⁵ 
// 树中各节点的值均保证唯一。 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 129 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution285 {
    /**
     * 方法1：直接按照中序遍历 将数据存到队列里面，然后找到节点p, 若p存在，且队列不为空，则返回p后面的元素，否则返回null
     *
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Deque<TreeNode> queue = new LinkedList<>();
        inorderNext(root, queue);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            if (node.val == p.val) {
                break;
            }
        }
        return queue.isEmpty() ? null : queue.pop();
    }

    public void inorderNext(TreeNode root, Deque<TreeNode> queue) {
        if (root == null) {
            return;
        }

        inorderNext(root.left, queue);
        queue.add(root);
        inorderNext(root.right, queue);
    }

    /**
     * 优化：
     * 实际上不需要把遍历到的元素全部存起来，我们只需要遍历到节点p 以及它之后遍历的第一个节点，找到之后就可以返回了
     * 所以需要一个全局变量，found ,确认是否在树中 找到了节点 p ，找到了 p ，就遍历其后面的一个节点，找到了就可以返回了
     *
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        found = false;
        Deque<TreeNode> queue = new LinkedList<>();
        inorderNext2(root, p, queue);
        if (queue.isEmpty() || queue.size() == 1) {
            return null;
        }

        return queue.peekLast();
    }

    public void inorderNext2(TreeNode root, TreeNode p, Deque<TreeNode> queue) {
        if (root == null) {
            return;
        }
        inorderNext2(root.left, p, queue);
        if (p.val == root.val) {
            found = true;
        }
        if (queue.size() > 1) {
            return;
        }
        if (found) {
            queue.add(root);
        }
        inorderNext2(root.right, p, queue);
    }

    public static boolean found;

    /**
     * 优化：
     * 方法2中 用到了全局变量；但是还没有用到 二叉搜索树的性质：当前节点的值 大于 左子树的节点的值，小于右子树 所有节点的值
     * 是否可以使用二叉搜索树的性质？
     * 实际上只需要记录next 节点即可，
     *      当 节点值 > p.val ，结果在左子树，next节点应该是【当前节点】
     *      当 节点值 <= p.val，此时还无法记录next节点，所以继续遍历右子树，直到遍历完成
     *      那么在右子树时，next节点何时标记的呢，在rt.val > p.val时；
     *          举一个极端的例子：p为左子树的最右节点，那么一开始 rt.val > p.val，next为当前节点；
     *              接下来一直为 rt.val <= p.val，直到遍历完左子树的所有右节点，那么之前标记的next就是 p的中序后继节点
     *
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor3(TreeNode root, TreeNode p) {
        TreeNode next = null;
        TreeNode rt = root;
        while (rt != null){
            if(rt.val > p.val){
                next = rt;
                rt = rt.left;
            }else if(rt.val <= p.val) {
                rt = rt.right;
            }
        }
        return next;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode() {
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
