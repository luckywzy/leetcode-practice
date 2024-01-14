package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution5Test {

    @Test
    public void longestPalindrome() {
        assertEquals("aba", new Solution5().longestPalindrome("babad"));
        assertEquals("bb", new Solution5().longestPalindrome("cbbd"));
        assertEquals("bbbabbb", new Solution5().longestPalindrome("abbbbabbb"));
    }
}