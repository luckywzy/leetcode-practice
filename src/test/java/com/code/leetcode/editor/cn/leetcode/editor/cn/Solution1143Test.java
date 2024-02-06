package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution1143Test {

    @Test
    public void longestCommonSubsequence() {
        assertEquals(3,new Solution1143().longestCommonSubsequence("ace", "abcde"));
        assertEquals(3,new Solution1143().longestCommonSubsequence("abcde", "ace"));
        assertEquals(3,new Solution1143().longestCommonSubsequence("abc", "abc"));
        assertEquals(0,new Solution1143().longestCommonSubsequence("abc", "def"));
    }
}