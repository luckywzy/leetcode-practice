package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution28Test {

    @Test
    public void strStr() {
        assertEquals(0, new Solution28().strStr("sadbutsad", "sad"));
        assertEquals(-1, new Solution28().strStr("leetcode", "leeto"));
        assertEquals(4, new Solution28().strStr("leetcode", "co"));
        assertEquals(4, new Solution28().strStr("abcde", "e"));
    }
}