package com.code.leetcode.editor.cn;

//单词的 广义缩写词 可以通过下述步骤构造：先取任意数量的不重叠的子字符串，再用它们各自的长度进行替换。例如，"abcde" 可以缩写为 "a3e"（
//"bcd" 变为 "3" ），"1bcd1"（"a" 和 "e" 都变为 "1"），"23"（"ab" 变为 "2" ，"cde" 变为 "3" ）。 
//
// 给你一个字符串 word ，返回一个由所有可能 广义缩写词 组成的列表。按 任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：word = "word"
//输出：["4","3d","2r1","2rd","1o2","1o1d","1or1","1ord","w3","w2d","w1r1","w1rd",
//"wo2","wo1d","wor1","word"]
// 
//
// 示例 2： 
//
// 
//输入：word = "a"
//输出：["1","a"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 15 
// word 仅由小写英文字母组成 
// 
// Related Topics 位运算 字符串 回溯 👍 73 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution320 {
    /**
     * 不是很明白，回溯不太会，
     * @param word
     * @return
     */
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>((int) Math.pow(2, word.length()));
        String sb = "";
        generateAbbreviations(word.toCharArray(), 0, sb, 0, res);
        return res;
    }

    private void generateAbbreviations(char[] charArr, int index, String sb, int cnt, List<String> res) {
        if (index >= charArr.length) {
            if (cnt > 0) {
                sb = sb + cnt + "";
            }
            res.add(sb);
            return;
        }

        generateAbbreviations(charArr, index + 1, sb, cnt + 1, res);
        generateAbbreviations(charArr, index + 1, sb + (cnt > 0 ? cnt : "") + charArr[index], 0, res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
