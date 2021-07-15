package com.code;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/7/7 5:24 下午
 */
public class Solution255Test {

    @Test
    public void verifyPreorder() {
        Solution255 solution255 = new Solution255();

        assertTrue(solution255.verifyPreorder(new int[]{5, 2, 1, 3, 6}));

        assertFalse(solution255.verifyPreorder(new int[]{5, 2, 6, 1, 3}));
    }


    @Test
    public void verifyPreorder1() {
        Solution255 solution255 = new Solution255();

        assertTrue(solution255.verifyPreorder(new int[]{1,2}));
    }

    @Test
    public void verifyPreorder2() {
        Solution255 solution255 = new Solution255();

        assertTrue(solution255.verifyPreorder(new int[]{2,1}));
    }
}