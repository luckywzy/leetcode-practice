package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution474Test {

    @Test
    public void findMaxForm() {
        int maxForm = new Solution474().findMaxForm(new String[]{
                "10", "0001", "111001", "1", "0"
        }, 5, 3);
        assertEquals(4, maxForm);
    }
    @Test
    public void findMaxForm1() {
        int maxForm = new Solution474().findMaxForm(new String[]{
                "10", "0", "1"
        }, 1, 1);
        assertEquals(2, maxForm);
    }
}