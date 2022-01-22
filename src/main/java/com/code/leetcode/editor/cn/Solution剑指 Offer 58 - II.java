package com.code.leetcode.editor.cn;

//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数
//将返回左旋转两位得到的结果"cdefgab"。 
//
// 
//
// 示例 1： 
//
// 输入: s = "abcdefg", k = 2
//输出: "cdefgab"
// 
//
// 示例 2： 
//
// 输入: s = "lrloseumgh", k = 6
//输出: "umghlrlose"
// 
//
// 
//
// 限制： 
//
// 
// 1 <= k < s.length <= 10000 
// 
// Related Topics 数学 双指针 字符串 👍 185 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution58 {

    /**
     * abcdefg
     * ba-gfedc
     * cdefgab
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords2(String s, int n) {
        char[] chars = s.toCharArray();
        revertXY(chars, 0, n - 1);
        revertXY(chars, n, s.length() - 1);
        revertXY(chars, 0, s.length() - 1);

        return String.valueOf(chars);
    }

    private void revertXY(char[] chars, int x, int y) {
        while (x < y) {
            char t = chars[x];
            chars[x] = chars[y];
            chars[y] = t;
            x++;
            y--;
        }
    }


    public String reverseLeftWords1(String s, int n) {
        char[] chars = s.toCharArray();
        while (n-- > 0) {
            leftMove(chars, s.length());
        }
        return String.valueOf(chars);
    }

    private char[] leftMove(char[] chars, int len) {
        char t = chars[0];
        if (len - 1 >= 0) System.arraycopy(chars, 1, chars, 0, len - 1);
        chars[len - 1] = t;
        return chars;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
