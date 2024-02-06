package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution165Test {

    @Test
    public void compareVersion() {
        assertEquals(0, new Solution165().compareVersion("1.01", "1.001"));
        assertEquals(0, new Solution165().compareVersion("1.0", "1.0.0"));
        assertEquals(-1, new Solution165().compareVersion("0.1", "1.1"));
        assertEquals(1, new Solution165().compareVersion("1.0.0.1", "1.0"));
    }
}