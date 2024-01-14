package com.code.leetcode.editor.cn.leetcode.editor.cn;//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 1957 👎 0


import java.util.Arrays;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution416 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        // dp[i][j] 表示任意取取元素0..i，放到容量j里，能达到的最大和是多少。
        // dp[i][j] = 不取i，dp[i-1][j], 取i，dp[i][j-num[i]] + num[i]
        // dp[0..i][0] = 0; dp[0][j] = num[0]
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        int[] dp = new int[target + 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }


    public boolean canPartition_1(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        // dp[i][j] 表示任意取取元素0..i，放到容量j里，能达到的最大和是多少。
        // dp[i][j] = 不取i，dp[i-1][j], 取i，dp[i][j-num[i]] + num[i]
        // dp[0..i][0] = 0; dp[0][j] = num[0]
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        int[][] dp = new int[nums.length][target + 1];
        for (int j = nums[0]; j <= target; j++) {
            dp[0][j] = nums[0];
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - nums[i]] + nums[i]);
                }
            }
            if (dp[i][target] == target) return true;
        }

        return dp[nums.length - 1][target] == target;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
