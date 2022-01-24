package com.code.leetcode.editor.cn;

//给你一个字符串 S，找出所有长度为 K 且不含重复字符的子串，请你返回全部满足要求的子串的 数目。 
//
// 
//
// 示例 1： 
//
// 输入：S = "havefunonleetcode", K = 5
//输出：6
//解释：
//这里有 6 个满足题意的子串，分别是：'havef','avefu','vefun','efuno','etcod','tcode'。
// 
//
// 示例 2： 
//
// 输入：S = "home", K = 5
//输出：0
//解释：
//注意：K 可能会大于 S 的长度。在这种情况下，就无法找到任何长度为 K 的子串。 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 10^4 
// S 中的所有字符均为小写英文字母 
// 1 <= K <= 10^4 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 34 👎 0


import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1100 {

    public int numKLenSubstrNoRepeats(String s, int k) {
        HashSet<Character> set = new HashSet<>();
        int l=0,h=0,res=0;
        while (h < s.length()){
            if(!set.contains(s.charAt(h))){
                set.add(s.charAt(h));
                h++;
            }else {
                set.remove(s.charAt(l));
                l++;
            }
            if(set.size() == k){
                res ++;

                set.remove(s.charAt(l));
                l++;
            }
        }

        return res;
    }


    /**
     *
     * 滑动窗口1
     * 用l,h 表示当前扫描到的数组，用int[] exist 表示l,h之间的字符出现的次数，再用另外一个变量cnt 标识字符种类
     * 当 exist[h] >1 时，表明有重复字符，此时cnt 不变
     * 当 h-l + 1 == k 时，
     *      1、当cnt == k  时，满足要求，则res ++;
     *      2、此时需要移动l，exist[l] --， l++，if(exist[s[l]] == 0){cnt --;}
     *
     * @param s
     * @param k
     * @return
     */
    public int numKLenSubstrNoRepeats2(String s, int k) {
        if(s.length() < k){
            return 0;
        }

        int[] exist = new int[26];
        int l = 0;
        int h = 0;
        int cnt = 0;
        int res = 0;
        while (h < s.length()) {
            exist[chIndex(s.charAt(h))]++;
            if (exist[chIndex(s.charAt(h))] == 1) {
                cnt++;
            }
            int len = h - l + 1;
            if (len == k) {
                if (cnt == k) {
                    res++;
                }

                exist[chIndex(s.charAt(l))]--;
                if (exist[chIndex(s.charAt(l))] == 0) {
                    cnt--;
                }
                l++;
            }
            h++;

        }

        return res;
    }

    private int chIndex(char c) {
        return c - 'a';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
