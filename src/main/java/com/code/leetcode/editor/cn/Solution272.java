package com.code.leetcode.editor.cn;

//给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的 k 个值。 
//
// 注意： 
//
// 
// 给定的目标值 target 是一个浮点数 
// 你可以默认 k 值永远是有效的，即 k ≤ 总结点数 
// 题目保证该二叉搜索树中只会存在一种 k 个值集合最接近目标值 
// 
//
// 示例： 
//
// 输入: root = [4,2,5,1,3]，目标值 = 3.714286，且 k = 2
//
//    4
//   / \
//  2   5
// / \
//1   3
//
//输出: [4,3] 
//
// 拓展： 
//假设该二叉搜索树是平衡的，请问您是否能在小于 O(n)（n 为总结点数）的时间复杂度内解决该问题呢？ 
// Related Topics 栈 树 深度优先搜索 二叉搜索树 双指针 二叉树 堆（优先队列） 👍 87 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

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
class Solution272 {
    /**
     * 解法1：
     * 需要解决的问题是在遍历BST的过程中积累 距离target 距离最近的topK 个元素
     * 那最简单的办法就是：遍历一遍，依此添加元素到集合中，元素个数直到K时，新增的元素需要判断是否距离是否比集合中的元素小，如果小则替换集合中的距离最远的元素
     * @param root
     * @param target
     * @param k
     * @return
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        TreeMap<Integer, Double> sortMap = new TreeMap<>();
        new ArrayList<Integer>();
        search(root, target, k, sortMap);
        return new ArrayList<>(sortMap.keySet());
    }

    public void search(TreeNode root, double target, int k, TreeMap<Integer, Double> sortMap) {
        if (root == null) {
            return;
        }
        double abs = abs(target, root.val);
        if (sortMap.size() < k) {
            sortMap.put(root.val, abs);
        } else {
            NavigableMap<Integer, Double> navigableMap = sortMap.descendingMap();
            Map.Entry<Integer, Double> maxDist = null;
            double dist = abs(target, root.val);
            for (Map.Entry<Integer, Double> entry : navigableMap.entrySet()) {
                if (dist < entry.getValue()) {
                    if (maxDist == null) {
                        maxDist = entry;
                    } else if (maxDist.getValue() < entry.getValue()) {
                        maxDist = entry;
                    }
                }
            }
            if (maxDist != null) {
                sortMap.remove(maxDist.getKey());
                sortMap.put(root.val, dist);
            }
        }

        search(root.left, target, k, sortMap);
        search(root.right, target, k, sortMap);
    }

    double abs(double tar, int val) {
        return Math.abs(tar - val);
    }


    /**
     * 2
     * BST在中序时，是从小到达的顺序，那么加入到集合中的元素，距target的距离大小，按照target的位置分析：
     * （1）在树中间，集合元素是 从大到小
     * （2）在树右边，集合元素是 从大到小
     * （3）在树左边，从小到大
     * 那么当集合元素个数 为 K 后，新增元素T时， 判断T 和 集合头的元素 距target的大小，T的大，则无需增加，同时T往后的元素肯定比T大，所以此时遍历结束了
     * 当T的距离小，则把集合头元素剔除，在尾部增加元素T，情况（1）和（2）都一样
     * 情况（3），T的距离大时，无需添加；T的距离小，不会出现，因为之前遍历的元素一定是比T要小的！！！
     * 所以需要的数据结构是队列，遍历顺序是中序遍历
     * @param root
     * @param target
     * @param k
     * @return
     */
    public List<Integer> closestKValues1(TreeNode root, double target, int k) {
        Queue<Integer> queue = new LinkedList<>();
        searchInOrder(root, target, k, queue);
        return new ArrayList(queue);
    }

    private void searchInOrder(TreeNode root, double target, int k, Queue<Integer> queue) {
        if (root == null) {
            return;
        }
        searchInOrder(root.left, target, k, queue);
        if (queue.size() < k) {
            queue.add(root.val);
        } else {
            if (queue.size() == k && abs(target, queue.peek()) > abs(target, root.val)) {
                queue.poll();
                queue.add(root.val);
            } else {
                return;
            }
        }
        searchInOrder(root.right, target, k, queue);
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
