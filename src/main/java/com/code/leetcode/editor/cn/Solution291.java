package com.code.leetcode.editor.cn;

//给你一种规律 pattern 和一个字符串 str，请你判断 str 是否遵循其相同的规律。 
//
// 这里我们指的是 完全遵循，例如 pattern 里的每个字母和字符串 str 中每个 非空 单词之间，存在着 双射 的对应规律。双射 意味着映射双方一一对
//应，不会存在两个字符映射到同一个字符串，也不会存在一个字符分别映射到两个不同的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：pattern = "abab", s = "redblueredblue"
//输出：true
//解释：一种可能的映射如下：
//'a' -> "red"
//'b' -> "blue" 
//
// 示例 2： 
//
// 
//输入：pattern = "aaaa", s = "asdasdasdasd"
//输出：true
//解释：一种可能的映射如下：
//'a' -> "asd"
// 
//
// 示例 3： 
//
// 
//输入：pattern = "abab", s = "asdasdasdasd"
//输出：true
//解释：一种可能的映射如下：
//'a' -> "a"
//'b' -> "sdasd"
//注意 'a' 和 'b' 不能同时映射到 "asd"，因为这里的映射是一种双射。
// 
//
// 示例 4： 
//
// 
//输入：pattern = "aabb", s = "xyzabcxzyabc"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 0 <= pattern.length <= 20 
// 0 <= s.length <= 50 
// pattern 和 s 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 回溯 👍 62 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution291 {
    /**
     * abab -> redblueredblue
     * a -> r, b -> e
     * a -> re, b ->d
     * a -> red,b
     *
     * @param pattern
     * @param s
     * @return
     */
    HashMap<Character, String> map = new HashMap<>();

    public boolean wordPatternMatch(String pattern, String s) {
        //都映射完了，则为true
        if (pattern.length() == 0) {
            return s.length() == 0;
        }
        // s的剩余长度 不能比patten要短，否则没办法匹配了 s.length()-pattern.length()
        char slice = pattern.charAt(0);
        for (int i = 1; i <= s.length() - pattern.length() + 1; i++) {
            String substr = s.substring(0, i);
            String mapStr = map.get(slice);
            //正向匹配，反向匹配
            if ((mapStr != null && mapStr.equals(substr)) ||
                    (mapStr == null && !map.containsValue(substr))) {
                map.put(slice, substr);
                //相等 || 不存在当前的映射，继续下一个
                if (wordPatternMatch(pattern.substring(1), s.substring(i))) {
                    return true;
                } else if (mapStr == null) {
                    //当前长度的映射是无效的，删除，继续下一长度的映射
                    map.remove(slice);
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
