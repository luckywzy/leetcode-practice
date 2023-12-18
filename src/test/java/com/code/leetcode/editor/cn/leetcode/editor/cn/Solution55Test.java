package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution55Test {

    @Test
    public void canJump() {
        boolean canJump = new Solution55().canJump(new int[]{3, 2, 1, 0, 4});
        assertFalse(canJump);
    }

    @Test
    public void canJump1() {
        boolean canJump = new Solution55().canJump(new int[]{2, 3, 1, 1, 4});
        assertTrue(canJump);
    }
}