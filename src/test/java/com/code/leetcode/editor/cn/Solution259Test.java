package com.code.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/7/16 5:27 下午
 */
public class Solution259Test {

    @Test
    public void threeSumSmaller() {
        Solution259 solution259 = new Solution259();

        assertEquals(2, solution259.threeSumSmaller(new int[]{-2, 0, 1, 3}, 2));
    }

    @Test
    public void threeSumSmaller1() {
        Solution259 solution259 = new Solution259();

        assertEquals(2, solution259.threeSumSmaller(new int[]{-2, 0, 3, 1}, 2));
    }

    @Test
    public void threeSumSmaller3() {
        Solution259 solution259 = new Solution259();

        assertEquals(0, solution259.threeSumSmaller(new int[]{1,0,-1}, 0));
    }

    @Test
    public void threeSumSmaller4() {
        Solution259 solution259 = new Solution259();

        assertEquals(3, solution259.threeSumSmaller(new int[]{3,1,0,-2}, 4));
    }

    @Test
    public void threeSumSmaller5() {
        Solution259 solution259 = new Solution259();

        assertEquals(151, solution259.threeSumSmaller(new int[]{3,2,-2,6,2,-2,6,-2,-4,2,3,0,4,4,1}, 3));
    }
}