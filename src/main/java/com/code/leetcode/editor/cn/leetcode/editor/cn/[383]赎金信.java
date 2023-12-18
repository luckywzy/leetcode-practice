package com.code.leetcode.editor.cn.leetcode.editor.cn;//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
//
// 如果可以，返回 true ；否则返回 false 。 
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ransomNote.length, magazine.length <= 10⁵ 
// ransomNote 和 magazine 由小写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 计数 👍 812 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> countMap = new HashMap<Character, Integer>();
        for (int i = 0; i< magazine.length(); i++){
            countMap.put(magazine.charAt(i), countMap.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        for (int i = 0; i<ransomNote.length(); i++){
            if (!countMap.containsKey(ransomNote.charAt(i))){
                return false;
            }
            countMap.put(ransomNote.charAt(i), countMap.getOrDefault(ransomNote.charAt(i), 0) - 1);

            if (countMap.get(ransomNote.charAt(i)) < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution383().canConstruct("b", "a"));
        System.out.println(new Solution383().canConstruct("aa", "ab"));
        System.out.println(new Solution383().canConstruct("aa", "aab"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
