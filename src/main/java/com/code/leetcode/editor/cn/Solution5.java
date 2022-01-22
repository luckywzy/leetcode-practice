package com.code.leetcode.editor.cn;

//给你一个字符串 s，找到 s 中最长的回文子串。 
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
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 👍 4552 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution5 {
    /**
     * 解法1：暴力解法
     * 直接找出所有子串，判断其是否为回文即可，超时
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        for (int i = s.length(); i >= 0; i--) {
            for (int l = 0; l < s.length(); l++) {
                String sub = s.substring(l, i);
                if (isPalindrome(sub)) {
                    return sub;
                }
            }
        }
        return "";
    }

    private boolean isPalindrome(String substring) {
        int l = 0;
        int r = substring.length() - 1;
        while (l < r) {
            if (substring.charAt(l) != substring.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    /**
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        return "";
    }

}
//leetcode submit region end(Prohibit modification and deletion)
