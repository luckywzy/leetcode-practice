package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution738Test {

    @Test
    public void monotoneIncreasingDigits() {
        int digits = new Solution738().monotoneIncreasingDigits(10);
        assertEquals(9, digits);
    }

    @Test
    public void monotoneIncreasingDigits1() {
        int digits = new Solution738().monotoneIncreasingDigits(1234);
        assertEquals(1234, digits);
    }

    @Test
    public void monotoneIncreasingDigits2() {
        int digits = new Solution738().monotoneIncreasingDigits(332);
        assertEquals(299, digits);
    }

    @Test
    public void monotoneIncreasingDigits3() {
        int digits = new Solution738().monotoneIncreasingDigits(1232);
        assertEquals(1229, digits);
    }
}