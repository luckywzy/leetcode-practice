package com.code.leetcode.editor.cn;

//给定一个字符串，对该字符串可以进行 “移位” 的操作，也就是将字符串中每个字母都变为其在字母表中后续的字母，比如："abc" -> "bcd"。这样，我们可
//以持续进行 “移位” 操作，从而生成如下移位序列： 
//
// "abc" -> "bcd" -> ... -> "xyz" 
//
// 给定一个包含仅小写字母字符串的列表，将该列表中所有满足 “移位” 操作规律的组合进行分组并返回。 
//
// 
//
// 示例： 
//
// 输入：["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"]
//输出：
//[
//  ["abc","bcd","xyz"],
//  ["az","ba"],
//  ["acef"],
//  ["a","z"]
//]
//解释：可以认为字母表首尾相接，所以 'z' 的后续为 'a'，所以 ["az","ba"] 也满足 “移位” 操作规律。 
// Related Topics 数组 哈希表 字符串 👍 72 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution249 {
    /**
     * 解法1：
     * "abc" 可以变成 "bcd"，那么我们可以把"bcd" 变成 "abc"，
     * 也就是说把'位移'后的字符串，还原为以a开头的字符串，如果A，B两个字符串还原后的字符串相同，
     * 那么A，B就是满足位移操作的
     * 即：用map存储存储，key为：还原为以a开头的字符串，val：源字符串列表
     * 如果map中不存在还原后的key，则新增
     *
     * 解法2：{@link com.code.Solution249}
     * @param strings
     * @return
     */
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String from = helper(s);
            map.computeIfAbsent(from, key->new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    private String helper(String s) {
        if(s.equals("a")){
            return "a";
        }

        char ch = s.charAt(0);
        //位移距离
        int moveLen = ch - 'a';
        StringBuilder sb = new StringBuilder(s.length());
        sb.append('a');
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            char reIndex = (char) ('a' + (c - 'a' - moveLen + 26) % 26);
            sb.append(reIndex);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
