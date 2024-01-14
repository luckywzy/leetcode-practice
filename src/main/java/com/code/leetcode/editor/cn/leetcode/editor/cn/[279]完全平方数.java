package com.code.leetcode.editor.cn.leetcode.editor.cn;
//给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。 
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：3 
//解释：12 = 4 + 4 + 4 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：2
//解释：13 = 4 + 9 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数学 动态规划 👍 1881 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution279 {
    public int numSquares(int n) {
        /**
         * nums 1,4,9,16,...
         * dp j 等于 j==n时，和为N的完全平方数的最少数量
         * dp[12] = min(dp[12-1],dp[12-4], dp[12-9])
         * dp[j] = dp[j-nums[i]] + 1 , 最小 取 min
         * 初始化，dp[1]=1,dp[0]=0, dp[2...n] = int max ,否则无法取最小
         *
         */
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 2, n + 1, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
