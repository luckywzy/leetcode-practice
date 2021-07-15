package com.code;

class Solution186 {
    /**
     * https://leetcode-cn.com/problems/reverse-words-in-a-string-ii/
     *
     * @param s
     */
    public void reverseWords(char[] s) {
        String[] strings = String.valueOf(s).split(" ");

        int l = 0;
        for (int i = strings.length - 1; i >= 0; i--) {
            String s1 = strings[i];
            for (int j = 0; j < s1.length(); j++) {
                s[l] = s1.charAt(j);
                l++;
            }
            if (l < s.length) {
                s[l] = ' ';
                l++;
            }
        }
    }

    /**
     * 先翻转每个单词，再将整体翻转
     *
     * @param s
     */
    public void reverseWords1(char[] s) {
        int l = 0;
        int h = s.length - 1;
        for (int i = 0; i < h; i++) {
            if (s[i] == ' ') {
                swap(s, l, i - 1);
                l = i + 1;
            }
        }
        swap(s, l, h);
        swap(s, 0, h);
    }

    private void swap(char[] s, int l, int h) {
        while (l < h) {
            char t = s[l];
            s[l] = s[h];
            s[h] = t;
            l++;
            h--;
        }
    }
}