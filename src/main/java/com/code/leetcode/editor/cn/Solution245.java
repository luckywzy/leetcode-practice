package com.code.leetcode.editor.cn;

//给定一个字符串数组 wordsDict 和两个字符串 word1 和 word2 ，返回列表中这两个单词之间的最短距离。 
//
// 注意：word1 和 word2 是有可能相同的，并且它们将分别表示为列表中 两个独立的单词 。 
//
// 
//
// 示例 1： 
//
// 
//输入：wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = 
//"makes", word2 = "coding"
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = 
//"makes", word2 = "makes"
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= wordsDict.length <= 10⁵ 
// 1 <= wordsDict[i].length <= 10 
// wordsDict[i] 由小写英文字母组成 
// word1 和 word2 都在 wordsDict 中 
// 
// Related Topics 数组 字符串 👍 41 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution245 {

    /**
     * 两种情况分开讨论
     * 1、 word1 == word2
     * 2、word1 ！= word2
     * @param wordsDict
     * @param word1
     * @param word2
     * @return
     */
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int minLen = Integer.MAX_VALUE;
        if (word1.equals(word2)) {
            for (int i = 0, wordsDictLength = wordsDict.length; i < wordsDictLength; i++) {
                if (wordsDict[i].equals(word1)) {
                    if (index1 != -1) {
                        index2 = index1;
                        minLen = Math.min(Math.abs(i - index2), minLen);
                    }
                    index1 = i;
                }
            }
        } else {
            for (int i = 0, wordsDictLength = wordsDict.length; i < wordsDictLength; i++) {
                String s = wordsDict[i];
                if (s.equals(word1)) {
                    index1 = i;
                }
                if (s.equals(word2)) {
                    index2 = i;
                }
                if (index1 != index2 && index1 != -1 && index2 != -1) {
                    minLen = Math.min(Math.abs(index1 - index2), minLen);
                }

            }
        }
        return minLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
