package com.code.leetcode.editor.cn;

//给定一个字符串，逐个翻转字符串中的每个单词。 
//
// 示例： 
//
// 输入: ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
//输出: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"] 
//
// 注意： 
//
// 
// 单词的定义是不包含空格的一系列字符 
// 输入字符串中不会包含前置或尾随的空格 
// 单词与单词之间永远是以单个空格隔开的 
// 
//
// 进阶：使用 O(1) 额外空间复杂度的原地解法。 
// Related Topics 双指针 字符串 👍 72 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution186 {
    public void reverseWords(char[] s) {

        int l = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                swap(s, l, i - 1);
                l = i + 1;
            }
        }
        swap(s, l, s.length - 1);
        swap(s, 0, s.length - 1);
    }

    void swap(char[] word, int l, int h) {
        while (l < h) {
            char t = word[l];
            word[l] = word[h];
            word[h] = t;
            l++;
            h--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
