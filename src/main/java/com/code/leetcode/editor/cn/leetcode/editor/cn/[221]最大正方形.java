package com.code.leetcode.editor.cn.leetcode.editor.cn;
//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 1610 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution221 {
    public int maximalSquare(char[][] matrix) {
        //dp[i][j] 表示以i,j 为右下角的最大正方形边长
        // dp[i][j] 递推，matrix[i][j]=1
        //               min(dp[i][j-1], dp[i-1][j] , dp[i-1][j-1]) +1
        // 初始化：dp[0][0..j] = matrix[0][0..j]
        //        dp[0..i][0] = matrix[0..i][0]
        // 遍历顺序：i: 0..matrix.len
        //          j: 0..i
        // 结果：res = max(dp[i][j], res); res*res

        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
        }
        for (int j = 0; j < matrix[0].length; j++) {
            dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
        }

        int res = 0;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res * res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
