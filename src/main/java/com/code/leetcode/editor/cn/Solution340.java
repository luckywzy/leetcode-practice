package com.code.leetcode.editor.cn;

//给定一个字符串 s ，找出 至多 包含 k 个不同字符的最长子串 T。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "eceba", k = 2
//输出: 3
//解释: 则 T 为 "ece"，所以长度为 3。 
//
// 示例 2: 
//
// 
//输入: s = "aa", k = 1
//输出: 2
//解释: 则 T 为 "aa"，所以长度为 2。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// 0 <= k <= 50 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 167 👎 0


import org.jboss.marshalling.util.IntMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution340 {
    /**
     * 方法1：滑动窗口加 hash表
     * 问题求解是的： 至多 包含 k 个不同字符的最长子串 T，即连续的子串；
     *      所以可以用Map的长度记录不同字符数量，然后用Val记录出现的次数；在遍历过后需要将其从Map中清除；
     *      那么遍历的过程中，判断Map的size是否<=K,记录其中最大的size 即可
     * @param s
     * @param k
     * @return
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }
        if (s.length() <= k) {
            return s.length();
        }
        int l = 0;
        int r = 0;
        int maxLen = 0;
        Map<Character, Integer> characterMap = new HashMap<>(s.length() / 2);
        do {
            characterMap.compute(s.charAt(r), (key, oldVal) -> oldVal == null ? 1 : oldVal + 1);

            if (characterMap.size() <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            } else {
                characterMap.size();
                Integer cnt = characterMap.get(s.charAt(l));
                if (cnt == 1) {
                    characterMap.remove(s.charAt(l));
                } else {
                    characterMap.put(s.charAt(l), cnt - 1);
                }
                l++;
            }
            r++;
        } while (r < s.length());

        return maxLen;
    }

    /**
     * 方法2：优化执行效率
     * 因为都是字符，则可以直接用数组的下标记录字符，值记录出现的次数
     * @param s
     * @param k
     * @return
     */
    public int lengthOfLongestSubstringKDistinct2(String s, int k) {
        if (k == 0) {
            return 0;
        }
        if (s.length() <= k) {
            return s.length();
        }
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int[] charsMap = new int[1024];
        int diffCount = 0;
        do {
            charsMap[s.charAt(r)]++;
            if (charsMap[s.charAt(r)] == 1) {
                diffCount++;
            }

            if (diffCount <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            } else {
                charsMap[s.charAt(l)] = charsMap[s.charAt(l)] - 1;
                if (charsMap[s.charAt(l)] == 0) {
                    diffCount--;
                }
                l++;
            }
            r++;
        } while (r < s.length());

        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
