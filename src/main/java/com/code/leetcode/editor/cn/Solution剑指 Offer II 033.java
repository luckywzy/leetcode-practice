package com.code.leetcode.editor.cn;

//给定一个字符串数组 strs ，将 变位词 组合在一起。 可以按任意顺序返回结果列表。 
//
// 注意：若两个字符串中每个字符出现的次数都相同，则称它们互为变位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// 
//
// 注意：本题与主站 49 题相同： https://leetcode-cn.com/problems/group-anagrams/ 
// Related Topics 哈希表 字符串 排序 👍 14 👎 0


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution033 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        Set<Integer> visited = new HashSet<>(strs.length);
        for (int i = 0; i < strs.length; i++) {
            List<String> tmp = new LinkedList<>();
            String str = strs[i];
            if (visited.contains(i)) {
                continue;
            }
            tmp.add(str);
            visited.add(i);
            for (int j = i + 1; j < strs.length; j++) {
                if (visited.contains(j) || str.length() != strs[j].length()) {
                    continue;
                }
                if (isContain(str, strs[j])) {
                    tmp.add(strs[j]);
                    visited.add(j);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    /**
     * 生成 hash 但是无法鉴别字符类型相同，数量不一致的情况
     * @param a
     * @param b
     * @return
     */
    public boolean isContain(String a, String b) {
        int hash = 0;
        for (int i = 0; i < a.length(); i++) {
            hash |= (1 << a.charAt(i) - 'a');
        }
        for (int i = 0; i < b.length(); i++) {
            if ((hash & (1 << b.charAt(i) - 'a')) == 0) {
                return false;
            }
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
