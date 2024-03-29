package com.code.leetcode.editor.cn.leetcode.editor.cn;//给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文组成 
// 1 <= k <= 10⁴ 
// 
//
// Related Topics 双指针 字符串 👍 556 👎 0


import java.util.stream.IntStream;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution541 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i = i + 2 * k) {
            int remind = i + k - 1;
            doReverse(chars, i, Math.min(remind, chars.length - 1));
        }
        return String.valueOf(chars);
    }

    private static void doReverse(char[] chars, int l, int r) {
        while (l < r) {
            char t = chars[l];
            chars[l] = chars[r];
            chars[r] = t;
            l++;
            r--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
