package com.code.leetcode.editor.cn.leetcode.editor.cn;//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s 和 t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
//
// Related Topics 哈希表 字符串 排序 👍 862 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution242 {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a'] --;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
       // System.out.println(new Solution242().isAnagram("anagram", "nagaram"));
        System.out.println(new Solution242().isAnagram("a", "ab"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
