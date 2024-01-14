package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution139Test {

    @Test
    public void wordBreak_backtrace_1() {
        assertEquals(true, new Solution139().wordBreak_backtrace("leetcode", List.of("leet", "code")));
    }

    @Test
    public void wordBreak_1() {
        assertEquals(true, new Solution139().wordBreak("leetcode", List.of("leet", "code")));
        assertEquals(true, new Solution139().wordBreak("applepenapple", List.of("apple", "pen")));
    }
}