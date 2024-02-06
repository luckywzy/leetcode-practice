package com.code.leetcode.editor.cn.leetcode.editor.cn;
//给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。 
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 
//
// 
// 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。 
// 
//
// 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：text1 = "abcde", text2 = "ace" 
//输出：3  
//解释：最长公共子序列是 "ace" ，它的长度为 3 。
// 
//
// 示例 2： 
//
// 
//输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc" ，它的长度为 3 。
// 
//
// 示例 3： 
//
// 
//输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text1.length, text2.length <= 1000 
// text1 和 text2 仅由小写英文字符组成。 
// 
//
// Related Topics 字符串 动态规划 👍 1509 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        /**
         *      0 1 2 3 4
         *      a b c d e
         *  0 a 1 0 0 0 0
         *  1 c 0 1 2 2 2
         *  2 e 0 1 2 2 3
         *
         */
        // dp[2][1] = dp[1][0]
        //dp[i][j] 表示遍历到 text1[i]，text2[j]时的最长公共子序列
        //dp[i][j] 递推，if( text1[i]==text2[j]){ dp[i][j] = max(dp[i-1][j-1], dp[i][j-1],dp[i-1][j]) +1;}
        // else {dp[i][j] = max(dp[i-1][j-1], dp[i][j-1],dp[i-1][j])];}
        //初始化：dp[0..i][0], if text1[i]==text2[0] dp[i][0] = 1
        //       dp[0][0...j], if text1[0]==text2[j] dp[0][j] = 1


        int[][] dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            dp[i][0] = text1.charAt(i) == text2.charAt(0) ? 1 : 0;
        }
        for (int j = 0; j < text2.length(); j++) {
            dp[0][j] = text1.charAt(0) == text2.charAt(j) ? 1 : 0;
        }

        for (int i = 1; i < text1.length(); i++) {
            for (int j = 1; j < text2.length(); j++) {
                int currentMax = Math.max(dp[i - 1][j - 1], Math.max(dp[i][j - 1], dp[i - 1][j]));
                dp[i][j] = currentMax;
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = currentMax + 1;
                }
            }
        }
        return dp[text1.length()-1][text2.length()-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
