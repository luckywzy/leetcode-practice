package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution509Test {

    @Test
    public void fib() {
        assertEquals(0, new Solution509().fib(0));
        assertEquals(1, new Solution509().fib(1));
        assertEquals(1, new Solution509().fib(2));
        assertEquals(2, new Solution509().fib(3));
    }

    @Test
    public void fib1() {
        //0,1,1,2,3
        assertEquals(3, new Solution509().fib(4));
    }
}