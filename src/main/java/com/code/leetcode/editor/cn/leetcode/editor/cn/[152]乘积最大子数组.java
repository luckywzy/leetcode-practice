package com.code.leetcode.editor.cn.leetcode.editor.cn;
//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 测试用例的答案是一个 32-位 整数。 
//
// 子数组 是数组的连续子序列。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10 <= nums[i] <= 10 
// nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数 
// 
//
// Related Topics 数组 动态规划 👍 2190 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution152 {
    public int maxProduct(int[] nums) {
        /**
         * dp[i] 定义为0..i的最大乘积
         * dp[i] = max (dp[i-1]*nums[i], nums[i])
         *      但是 nums[i] 为负数的话，这里是不满足的,负数会越乘越小
         *  所以分情况讨论：
         *      maxDp[i] = max(maxDp[i-1]*nums[i], max(minDp[i-1]*nums[i], nums[i])
         *      minDp[i] = min(minDp[i-1]*nums[i], min(maxDp[i-1]*nums[i], nums[i])
         *      ans = max (maxDp[i],minDp[i],ans)
         */
        int[] maxDp = new int[nums.length];
        int[] minDp = new int[nums.length];
        int ans = nums[0];
        maxDp[0] = nums[0];
        minDp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxDp[i] = Math.max(maxDp[i - 1] * nums[i], Math.max(minDp[i - 1] * nums[i], nums[i]));
            minDp[i] = Math.min(minDp[i - 1] * nums[i], Math.min(maxDp[i - 1] * nums[i], nums[i]));
            ans = Math.max(maxDp[i], ans);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
