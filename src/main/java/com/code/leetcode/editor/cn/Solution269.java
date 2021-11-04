package com.code.leetcode.editor.cn;

//现有一种使用英语字母的火星语言，这门语言的字母顺序与英语顺序不同。 
//
// 给你一个字符串列表 words ，作为这门语言的词典，words 中的字符串已经 按这门新语言的字母顺序进行了排序 。 
//
// 请你根据该词典还原出此语言中已知的字母顺序，并 按字母递增顺序 排列。若不存在合法字母顺序，返回 "" 。若存在多种可能的合法字母顺序，返回其中 任意一种
// 顺序即可。 
//
// 字符串 s 字典顺序小于 字符串 t 有两种情况： 
//
// 
// 在第一个不同字母处，如果 s 中的字母在这门外星语言的字母顺序中位于 t 中字母之前，那么 s 的字典顺序小于 t 。 
// 如果前面 min(s.length, t.length) 字母都相同，那么 s.length < t.length 时，s 的字典顺序也小于 t 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["wrt","wrf","er","ett","rftt"]
//输出："wertf"
// 
//
// 示例 2： 
//
// 
//输入：words = ["z","x"]
//输出："zx"
// 
//
// 示例 3： 
//
// 
//输入：words = ["z","x","z"]
//输出：""
//解释：不存在合法字母顺序，因此返回 "" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 100 
// words[i] 仅由小写英文字母组成 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 数组 字符串 
// 👍 163 👎 0


import java.util.ArrayDeque;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution269 {
    /**
     * 1、将 word 转换为临接表，表示入度出度
     *
     * @param words
     * @return
     */
    public String alienOrder(String[] words) {
        int[][] edge = new int[128][128];
        int[] chars = new int[128];
        ArrayDeque<Integer> indus = new ArrayDeque<>();
        for (String word : words) {
            for (int i = 0; i < word.length() - 1; i++) {
                chars[word.charAt(i)] = 1;
                chars[word.charAt(i + 1)] = 1;
                edge[word.charAt(i)][word.charAt(i + 1)] = 1;
                indus.add((int)word.charAt(i));
                indus.add((int)word.charAt(i+1));
            }
        }
        int[] ind = new int[128];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < 1) {
                continue;
            }
            //计算所有字符的入度，即这一列的入度
            for (int j = 0; j < 128; j++) {
                ind[i] += edge[j][i];
            }
            indus.add(i);
        }

        StringBuilder ans = new StringBuilder();
        while (!indus.isEmpty()) {
            //输出 入度为0 的字符，同时将其指向的其他字符的入度减掉
            Integer ch = indus.peek();
            if (ind[ch] == 0) {
                ans.append((char) ch.intValue());
                for (int k = 0; k < 128; k++) {
                    edge[ch][k] = 0;
                    if (ind[k] > 0) {
                        ind[k]--;
                    }
                }
                indus.removeFirst();
                //?
            }
        }

        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
