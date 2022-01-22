package com.code.leetcode.editor.cn;

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 6710 👎 0


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution3 {

    /**
     * 解析：
     * 寻找不重复子串的关键点就是找到上一次重复的字符位置，
     * 这样才能正确计算长度
     * 使用indexOf 方法找到上一次字符重复的位置
     * 使用 int[] chars 累计字符出现次数
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int[] chars = new int[256];
        int l = 0;
        int maxL = 0;

        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)]++;

            if (chars[s.charAt(i)] > 1) {
                int jp = s.indexOf(s.charAt(i), l);
                if (jp >= i) {
                    maxL = Math.max(maxL, i - l + 1);
                } else {
                    l = jp + 1;
                    maxL = Math.max(maxL, i - l + 1);
                }
                chars[s.charAt(i)]--;
            } else {
                maxL = Math.max(maxL, i - l + 1);
            }
        }
        return maxL;
    }

    /**
     * 解法2： 用一个set记录出现的字符，发现当前遍历的字符已存在说明重复了，需要重新计算
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int maxL = 0;
        for (int i = 0; i < s.length(); i++) {
            int l = i;
            /**
             * 每次都要新建set，可以重用，重用的关键是把 i < l部分的字符删掉
             */
            Set<Character> set = new HashSet<>();
            while (l < s.length()) {
                if (set.contains(s.charAt(l))) {
                    break;
                } else {
                    set.add(s.charAt(l));
                    maxL = Math.max(maxL, l - i + 1);
                }
                l++;
            }
        }
        return maxL;
    }

    /**
     * 解法3：
     * 实际上可以使用map来记录字符和出现的位置，就不需要内层循环了
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        int maxL = 0;
        int l = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                l = Math.max(l, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            maxL = Math.max(maxL, i - l + 1);
        }
        return maxL;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
