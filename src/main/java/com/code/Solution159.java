package com.code;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/5/21 4:36 下午
 */
public class Solution159 {
    /**
     * https://leetcode-cn.com/problems/longest-substring-with-at-most-two-distinct-characters/
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {

        int[] count = new int[265];
        int r;
        int l = 0;
        int type = 0;
        for (r = 0; r < s.length(); r++) {

            if (count[s.charAt(r)] == 0) {
                type++;
            }
            count[s.charAt(r)]++;

            if (type > 2) {
                count[s.charAt(l)]--;
                if (count[s.charAt(l)] == 0) {
                    type--;
                }
                l++;
            }
        }
        return r - l;
    }
}
