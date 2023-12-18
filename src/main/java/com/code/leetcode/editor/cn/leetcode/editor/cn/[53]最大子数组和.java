package com.code.leetcode.editor.cn.leetcode.editor.cn;//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
//
// Related Topics 数组 分治 动态规划 👍 6494 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution53 {
    public int maxSubArray_force(int[] nums) {
        int maxLen = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                result = Math.max(sum, result);
            }
        }
        return result;
    }

    //贪心
    public int maxSubArray_1(int[] nums) {
        int maxLen = 0;
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > result) {
                result = sum;
            }
            if (sum <= 0) { //当前连续子数组和小于0 时，立即重置
                sum = 0;
            }
        }
        return result;
    }

    // dp
    public int maxSubArray_2(int[] nums) {
        int maxLen = 0;

        int sum = 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+ nums[i], nums[i]);
            if (dp[i] > result){
                result = dp[i];
            }
        }
        return result;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
