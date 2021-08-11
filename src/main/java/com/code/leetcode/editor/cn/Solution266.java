package com.code.leetcode.editor.cn;

//给定一个字符串，判断该字符串中是否可以通过重新排列组合，形成一个回文字符串。 
//
// 示例 1： 
//
// 输入: "code"
//输出: false 
//
// 示例 2： 
//
// 输入: "aab"
//输出: true 
//
// 示例 3： 
//
// 输入: "carerac" c 2 r 2 a 2 e 1
//输出: true 
// Related Topics 位运算 哈希表 字符串 
// 👍 42 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution266 {
    /**
     * 偶数长度：那么每个字符的个数都是偶数个
     * 奇数长度：只有一个字符的个数是奇数个，剩下的也是偶数个
     *
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> cntMap = new HashMap<>(s.length() / 2);
        for (int i = 0; i < s.length(); i++) {
            cntMap.compute(s.charAt(i), (key, oldVal) -> oldVal == null ? 1 : oldVal + 1);
        }
        boolean isOdd = s.length() % 2 != 0;
        int oddCnt = 0;
        for (Map.Entry<Character, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddCnt += 1;
                if (isOdd && oddCnt > 1) {
                    return false;
                }
                if (!isOdd && oddCnt > 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 思路不变，优化空间消耗，使用int[128] 的下标标识字符，值表示出现的次数
     * @param s
     * @return
     */
    public boolean canPermutePalindrome1(String s) {
        int[] cnt = new int[128];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i)]++;
        }
        int oddCnt = 0;
        for (int c : cnt) {
            oddCnt += c % 2 != 0 ? 1 : 0;
            if (oddCnt > 1) {
                return false;
            }
        }
        return true;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
