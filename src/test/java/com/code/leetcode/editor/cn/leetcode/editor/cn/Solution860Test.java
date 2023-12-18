package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution860Test {

    @Test
    public void lemonadeChange() {
        boolean change = new Solution860().lemonadeChange(new int[]{5, 5, 5, 10, 20});
        assertTrue(change);
    }

    @Test
    public void lemonadeChange1() {
        boolean change = new Solution860().lemonadeChange(new int[]{5,5,10,10,20});
        assertFalse(change);
    }
}