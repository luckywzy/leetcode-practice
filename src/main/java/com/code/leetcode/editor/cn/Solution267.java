package com.code.leetcode.editor.cn;

//给定一个字符串 s ，返回其通过重新排列组合后所有可能的回文字符串，并去除重复的组合。 
//
// 如不能形成任何回文排列时，则返回一个空列表。 
//
// 示例 1： 
//
// 输入: "aabb"
//输出: ["abba", "baab"] 
//
// 示例 2： 
//
// 输入: "abc"
//输出: [] 
// Related Topics 哈希表 字符串 回溯 
// 👍 61 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution267 {

    /**
     * 【超时】直接使用递归全排列的方式，生成字符串的全排列，然后判断每个排列是否是回文串
     *
     * @param s
     * @return
     */
    public List<String> generatePalindromes(String s) {
        char[] ch = s.toCharArray();
        Set<String> ans = new HashSet<>(s.length());
        int[] cnt = new int[128];
        if (canPermutePalindrome1(s, cnt)) {
            generate(ch, 0, ch.length, ans);
        }

        return new ArrayList<>(ans);
    }

    private void generate(char[] s, int i, int j, Set<String> ans) {
        if (i == j) {
            //System.out.println(Arrays.toString(s));
            if (isPalindromes(s, j)) {
                ans.add(String.valueOf(s));
            }
        } else {
            for (int l = i; l < s.length; l++) {
                if (l == i || s[l] != s[i]) {
                    char c = s[l];
                    s[l] = s[i];
                    s[i] = c;
                    generate(s, i + 1, j, ans);
                    s[i] = s[l];
                    s[l] = c;
                }
            }
        }
    }

    private boolean isPalindromes(char[] s, int len) {
        int mid = len / 2;
        int i = 0;
        while ((s[i] == s[len - 1 - i])) {
            if (i >= mid) {
                return true;
            }
            i++;
        }
        return false;
    }

    public boolean canPermutePalindrome1(String s, int[] cnt) {
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


    /**
     * 优化版本：
     * 1、枚举字符串的全排列的时间复杂度太高，所以可否直接生成回文串的全排列
     * 2、首先判断是否可以生成回文串，同时生成每个字符出现的次数
     * 3、分别记录：出现一次的字符mid，和 出现偶数次的字符，例如出现6次的字符需要记录 6/2=3次，
     *    因为这些字符要组成长度为s/2的字符串s1，然后加上反转s1的字符串s1'才能组成长度为s的回文串
     * 4、使用全排列的方式生成s1全排列，s1 + mid + s1' 判断是否为回文串，是则添加到结果集中
     */
    public List<String> generatePalindromes1(String s) {
        Set<String> ans = new HashSet<>(s.length());
        int[] cnt = new int[128];
        if (canPermutePalindrome1(s, cnt)) {
            char[] subs = new char[s.length() / 2];
            char mid = 0;
            int index = 0;
            for (int i = 0; i < cnt.length; i++) {
                if (cnt[i] % 2 == 1) {
                    //是否有奇数个的字符
                    mid = (char) i;
                }
                if (cnt[i] > 1) {
                    //aaaaaa 向这种的需要在sub中占用3个位置，因为 s的长度是6，sub需要知道
                    for (int j = 0; j < cnt[i] / 2; j++) {
                        subs[index++] = (char) i;
                    }
                }
            }
            generate2(subs, 0, subs.length, ans, mid);
        }

        return new ArrayList<>(ans);
    }

    private void generate2(char[] s, int i, int j, Set<String> ans, char mid) {
        if (i == j) {
            String s1 = new String(s);
            String s2 = s1 + (mid == 0 ? "" : mid) + new StringBuilder(s1).reverse().toString();
            if (isPalindromes(s2.toCharArray(), s2.length())) {
                ans.add(s2);
            }
        } else {
            for (int l = i; l < s.length; l++) {
                if (l == i || s[l] != s[i]) {
                    char c = s[l];
                    s[l] = s[i];
                    s[i] = c;
                    generate2(s, i + 1, j, ans, mid);
                    s[i] = s[l];
                    s[l] = c;
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
