package com.code.leetcode.editor.cn.leetcode.editor.cn;
//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2380 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, Comparator.comparingInt(a->a));

        for (int i = 0; i < k; i++) {
            priorityQueue.offer(nums[i]);
        }

        for (int i = k ; i < nums.length; i++) {
            if(nums[i] > priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.offer(nums[i]);
            }
        }
        return priorityQueue.peek();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
