package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2022/1/16 8:09 下午
 */
public class Solution264Test {

    @Test
    public void nthUglyNumber() {
        Solution264 solution264 = new Solution264();
        //Assert.assertEquals(12, solution264.nthUglyNumber(10));
        Assert.assertEquals(388800, solution264.nthUglyNumber(418));
        //Assert.assertEquals(388800, solution264.nthUglyNumber(1690));
    }

    @Test
    public void nthUglyNumber2() {
        Solution264 solution264 = new Solution264();
        //Assert.assertEquals(12, solution264.nthUglyNumber(10));
        Assert.assertEquals(388800, solution264.nthUglyNumber(418));
    }

    @Test
    public void nthUglyNumber3() {
        Solution264 solution264 = new Solution264();
        Assert.assertEquals(12, solution264.nthUglyNumber(10));
        Assert.assertEquals(388800, solution264.nthUglyNumber(418));
        Assert.assertEquals(2123366400, solution264.nthUglyNumber(1690));
    }

}