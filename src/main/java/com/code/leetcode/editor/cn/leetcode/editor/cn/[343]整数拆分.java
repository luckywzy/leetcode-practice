package com.code.leetcode.editor.cn.leetcode.editor.cn;//给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
//
// 返回 你可以获得的最大乘积 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 
//输入: n = 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 
//
// 提示: 
//
// 
// 2 <= n <= 58 
// 
//
// Related Topics 数学 动态规划 👍 1326 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution343 {
    public int integerBreak(int n) {
        // dp i 表示 分拆数字 i 时，获得的最大乘积
        // dp[i] =  max {dp[i-j]*j, (i-j)*j, dp[i]}
        // dp[1] = 1; dp[2] = 1;
        // i -> 2..n  j -> 2..n

        int[] dp = new int[n + 1];
        dp[1] =1;
        dp[2] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= i; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, (i - j) * j));
            }
        }

        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
