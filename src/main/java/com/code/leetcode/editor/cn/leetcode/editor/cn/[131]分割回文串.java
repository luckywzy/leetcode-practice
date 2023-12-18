package com.code.leetcode.editor.cn.leetcode.editor.cn;//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 1696 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> path = new ArrayList<String>();
        backTrace(s, 0,  path, result);

        return result;
    }


    void backTrace(String s, int startIndex, List<String> path, List<List<String>> result) {
        if (startIndex == s.length()) {
            result.add(new ArrayList<>(path));
            path.clear();
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isCycle(s, startIndex, i)) {
                String tmp = s.substring(startIndex, i+1);
                path.add(tmp);
            }else {
                continue;
            }
            backTrace(s, i + 1, path, result);
        }
    }

    boolean isCycle(String s, int i, int j) {
        while (i < j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i ++;
            j -- ;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
