package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/12/19 12:14 下午
 */
public class Solution294Test {

    @Test
    public void canWin() {
        Solution294 solution294 = new Solution294();

        assertTrue(solution294.canWin("++++"));
    }

    @Test
    public void canWin1() {
        Solution294 solution294 = new Solution294();

        assertFalse(solution294.canWin("+"));
    }

    @Test
    public void canWin2() {
        Solution294 solution294 = new Solution294();

        assertTrue(solution294.canWin("++++++"));
    }


    @Test
    public void canWin3() {
        Solution294 solution294 = new Solution294();

        assertFalse(solution294.canWin("++++--++++"));
    }
}