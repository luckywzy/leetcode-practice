package com.code;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/5/21 7:09 下午
 */
public class Solution161Test {

    @Test
    public void isOneEditDistance() {
        assertTrue(new Solution161().isOneEditDistance1("a", "b"));
        assertTrue(new Solution161().isOneEditDistance1("ab", "b"));
        assertTrue(new Solution161().isOneEditDistance1("a", "ab"));
        assertTrue(new Solution161().isOneEditDistance1("ac", "bc"));
        assertTrue(new Solution161().isOneEditDistance1("acb", "abb"));
        assertFalse(new Solution161().isOneEditDistance1("acd", "bc"));
        assertTrue(new Solution161().isOneEditDistance1("aaa", "baa"));
        assertTrue(new Solution161().isOneEditDistance1("a", ""));
        assertTrue(new Solution161().isOneEditDistance1("", "a"));
        assertFalse(new Solution161().isOneEditDistance1("c", "c"));
        assertFalse(new Solution161().isOneEditDistance1("ab", "acd"));
        assertTrue(new Solution161().isOneEditDistance1("ab", "acb"));
        assertTrue(new Solution161().isOneEditDistance1("1203", "1213"));
    }
    @Test
    public void isOneEditDistance2() {
        assertTrue(new Solution161().isOneEditDistance2("a", "b"));
        assertTrue(new Solution161().isOneEditDistance2("ab", "b"));
        assertTrue(new Solution161().isOneEditDistance2("a", "ab"));
        assertTrue(new Solution161().isOneEditDistance2("ac", "bc"));
        assertTrue(new Solution161().isOneEditDistance2("acb", "abb"));
        assertFalse(new Solution161().isOneEditDistance2("acd", "bc"));
        assertTrue(new Solution161().isOneEditDistance2("aaa", "baa"));
        assertFalse(new Solution161().isOneEditDistance2("c", "c"));
        assertFalse(new Solution161().isOneEditDistance2("ab", "acd"));
        assertTrue(new Solution161().isOneEditDistance2("ab", "acb"));
        assertTrue(new Solution161().isOneEditDistance2("1203", "1213"));
    }
}