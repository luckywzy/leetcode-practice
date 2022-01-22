package com.code.leetcode.editor.cn;

//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
// Related Topics 栈 递归 字符串 👍 996 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution394 {
    //3[a]2[bc]
    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int len = chars.length;
        StringBuilder res = new StringBuilder();

        while (i < len) {
            StringBuilder dupNum = new StringBuilder();
            while ('0' <= chars[i] && chars[i] < '9') {
                dupNum.append(chars[i]);
                i++;
            }
            StringBuilder encodeStr = new StringBuilder();
            boolean hasEncodeStr = false;
            if (chars[i] == '[') {
                i++;
                while (('a' <= chars[i] && chars[i] <= 'z') || ('A' <= chars[i] && chars[i] <= 'Z')) {
                    encodeStr.append(chars[i]);
                    i++;
                    hasEncodeStr = true;
                }
            }
            if (('a' <= chars[i] && chars[i] <= 'z') || ('A' <= chars[i] && chars[i] <= 'Z')) {
                while (('a' <= chars[i] && chars[i] <= 'z') || ('A' <= chars[i] && chars[i] <= 'Z')) {
                    encodeStr.append(chars[i]);
                    i++;
                    hasEncodeStr = true;
                }
                res.append(encodeStr);
            }
            if (chars[i] == ']') {
                if (hasEncodeStr) {
                    dec(res, dupNum, encodeStr);
                }
                i++;
            } else {
                String decodeString = decodeString(new String(chars, i, len - i));
                encodeStr.append(decodeString);
                dec(res, dupNum, encodeStr);
                i = len;
            }
        }
        return res.toString();
    }

    private void dec(StringBuilder res, StringBuilder dupNum, StringBuilder encodeStr) {
        for (int j = 0; j < Integer.parseInt(dupNum.toString()); j++) {
            res.append(encodeStr);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
