package com.code.leetcode.editor.cn;

//给定一个数组 nums 和一个目标值 k，找到和等于 k 的最长连续子数组长度。如果不存在任意一个符合要求的子数组，则返回 0。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,-1,5,-2,3], k = 3
//输出: 4 
//解释: 子数组 [1, -1, 5, -2] 和等于 3，且长度最长。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,-1,2,1], k = 1
//输出: 2 
//解释: 子数组 [-1, 2] 和等于 1，且长度最长。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// -10⁹ <= k <= 10⁹ 
// 
// Related Topics 数组 哈希表 👍 144 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution325 {
    /**
     * 方法1： 直接枚举每个长度的元素的和，即可得出答案，会超时
     *
     * 方法2：使用Map记录前缀和，Key为前缀和，val 为第一次前缀和出现的位置，所以需要把 前缀和为0初始化为-1；
     *      接着，判断Map中是否存在preSum-k的前缀和，即preSum[j]-preSum[i] == k，如果存在记录其长度，输出最大的；
     *
     * @param nums
     * @param k
     * @return
     */
    public int maxSubArrayLen(int[] nums, int k) {
        //前缀和
        Map<Integer, Integer> prefixSumMap = new HashMap<>(nums.length);
        int preSum = 0;
        int ans = 0;
        prefixSumMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (!prefixSumMap.containsKey(preSum)) {
                prefixSumMap.put(preSum, i);
            }
            if (prefixSumMap.containsKey(preSum - k)) {
                ans = Math.max(ans, i - prefixSumMap.get(preSum - k));
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
