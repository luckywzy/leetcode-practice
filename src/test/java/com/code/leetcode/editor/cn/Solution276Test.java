package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/11/4 5:19 下午
 */
public class Solution276Test {

    @Test
    public void numWays() {
        Solution276 solution276 = new Solution276();
        int numWays = solution276.numWays(1, 1);
        Assert.assertEquals(1, numWays);
    }

    @Test
    public void numWays1() {
        Solution276 solution276 = new Solution276();
        int numWays = solution276.numWays(2, 2);
        Assert.assertEquals(4, numWays);
    }

    @Test
    public void numWays2() {
        Solution276 solution276 = new Solution276();
        int numWays = solution276.numWays(3, 2);
        Assert.assertEquals(6, numWays);
    }

    @Test
    public void numWays3() {
        Solution276 solution276 = new Solution276();
        int numWays = solution276.numWays(7, 2);
        Assert.assertEquals(42, numWays);
    }

    @Test
    public void numWays4() {
        Solution276 solution276 = new Solution276();
        int numWays = solution276.numWays(3, 3);
        Assert.assertEquals(24, numWays);
    }

    @Test
    public void numWays5() {
        Solution276 solution276 = new Solution276();
        int numWays = solution276.numWays(43, 2);
        Assert.assertEquals(1402817466, numWays);
    }
}