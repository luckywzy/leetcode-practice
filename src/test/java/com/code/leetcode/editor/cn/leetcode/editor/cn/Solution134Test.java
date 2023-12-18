package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution134Test {

    @Test
    public void canCompleteCircuit() {
        int canCompleteCircuit = new Solution134().canCompleteCircuit(
                new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
        assertEquals(3, canCompleteCircuit);
    }

    @Test
    public void canCompleteCircuit_1() {
        int canCompleteCircuit = new Solution134().canCompleteCircuit(
                new int[]{2,3,4}, new int[]{3, 4, 3});
        assertEquals(-1, canCompleteCircuit);
    }
}