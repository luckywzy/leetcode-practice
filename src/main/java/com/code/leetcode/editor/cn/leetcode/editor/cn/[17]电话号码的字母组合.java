package com.code.leetcode.editor.cn.leetcode.editor.cn;//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2700 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution17 {

    String[] mapping = {
            "", //0
            "", //1
            "abc", //2
            "def", //3
            "ghi", //4
            "jkl", //5
            "mno",//6
            "pqrs", //7
            "tuv", //8
            "wxyz", //9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        String combine = "";
        backTrace(digits, combine, 0, result);

        return result;
    }

    void backTrace(String digits, String combine, int startIndex, List<String> result) {
        if (combine.length() == digits.length()) {
            result.add(combine);
            return;
        }

        int index = digits.charAt(startIndex) - '0';
        String s = mapping[index];

        for (int j = 0; j < s.length(); j++) {
            backTrace(digits, combine + s.charAt(j), startIndex + 1, result);
        }

    }


}
//leetcode submit region end(Prohibit modification and deletion)
