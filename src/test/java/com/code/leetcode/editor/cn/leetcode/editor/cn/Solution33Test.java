package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution33Test {

    @Test
    public void search() {
        assertEquals(4, new Solution33().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        assertEquals(-1, new Solution33().search(new int[]{4,5,6,7,0,1,2}, 3));
    }
}