package com.code.leetcode.editor.cn.leetcode.editor.cn;
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3485 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        dfs(n, n, "", list);
        return list;
    }

    void dfs(int left, int right, String sb, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(sb);
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(left - 1, right, sb + "(", result);
        }
        if (right > 0) {
            dfs(left, right - 1, sb + ")", result);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
