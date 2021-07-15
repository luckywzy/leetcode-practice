package com.code;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/5/21 4:36 下午
 */
public class Solution161 {
    /**
     * https://leetcode-cn.com/problems/one-edit-distance/
     *
     * 解法：分情况讨论即可
     * case1：s.len < t.len, t 在 0..i的位置上删除一个字符，是否和s相等
     * case2：s.len > t.len, 将case1反转
     * case2: s.len == t.len, 将s中位置i的字符，替换为t中位置1的字符，判断是否相等
     * 备注：java 中生成subStr需要遍历字符串，性能上有折扣
     * @param s
     * @return
     */
    public boolean isOneEditDistance1(String s, String t) {
        if (s.length() == t.length() && s.length() == 0 ||
                Math.abs(s.length() - t.length()) > 1 ||
                s.equals(t)) {
            return false;
        }
        if (s.length() < t.length()) {
            return lessOne(s, t);
        }
        if (s.length() > t.length()) {
            return moreOne(s, t);
        }
        return replaceOneIsSame(s, t);
    }

    private boolean replaceOneIsSame(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
            if (diff > 1) {
                return false;
            }
        }
        return true;
    }

    private boolean lessOne(String a, String b) {
        return moreOne(b, a);
    }

    private boolean moreOne(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (b.equals(a.substring(0, i) + a.substring(i + 1))) {
                return true;
            }
        }
        return false;
    }


    public boolean isOneEditDistance2(String s, String t) {
        if (s.length() == t.length() && s.length() == 0 ||
                Math.abs(s.length() - t.length()) > 1 ||
                s.equals(t)) {
            return false;
        }
        if (s.length() > t.length()) {
            return isOneEditDistance2(t, s);
        }
        //s < l
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) {
                    return t.substring(i).equals(t.charAt(i) + s.substring(i + 1));
                }
                return s.substring(i).equals(t.substring(i + 1)) ||
                        t.substring(i).equals(s.substring(i + 1));

            }
        }
        return true;
    }
}
