package com.code.leetcode.editor.cn.leetcode.editor.cn;
//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。 
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
// 
//
// 示例 2： 
//
// 
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s 和 wordDict[i] 仅由小写英文字母组成 
// wordDict 中的所有字符串 互不相同 
// 
//
// Related Topics 字典树 记忆化搜索 数组 哈希表 字符串 动态规划 👍 2368 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        /**
         * 1、dp[j]=true 表示s中0...j的子串可以拆分为wordDict 中出现的字符串
         * 2、dp[j] = true 当 wordDict 包含s.sub(i,j)
         * 3、初始化：d[0]=true, 其他都是false
         * 4、遍历顺序 0..s.length
         * 5、返回 dp[s.length())
         */
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String s1 = s.substring(j, i);
                if (set.contains(s1) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public boolean wordBreak_backtrace(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        return dfs(s, 0, set);
    }

    public boolean dfs(String s, int startIndex, Set<String> set) {
        if (startIndex >= s.length()) {
            return true;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String s1 = s.substring(startIndex, i + 1);
            if (!set.contains(s1)) {
                continue;
            }
            if (dfs(s, i + 1, set)) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
