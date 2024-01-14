package com.code.leetcode.editor.cn.leetcode.editor.cn;
//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 7012 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution5 {
    public String longestPalindrome(String s) {
        //  dp[i][j] 表示 以区间内[i,j] 是回文子串的=true
        //  dp[i][j] 来自于，if(s[i] == s[j]) {
        //      i==j  dp[i]j[j] == true;
        //      j-i <=1  dp[i][j] == true;
        //      j-i > 1   dp[i][j] == dp[i+1][j-1]
        //  }
        //  初始化，dp[i][j] 为 false
        //  dp[i+1][j-1] 在左下角，所以遍历顺序要在从左往右，从下往上

        boolean[][] dp = new boolean[s.length()][s.length()];
        String res = "";
        int maxLength = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
                if (dp[i][j] && j - i > maxLength) {
                    maxLength = j - i;
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
