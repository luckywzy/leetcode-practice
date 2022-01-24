package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2022/1/24 11:53 上午
 */
public class Solution1151Test {

    @Test
    public void minSwaps() {
        Solution1151 solution1151 = new Solution1151();
        int minSwaps = solution1151.minSwaps(new int[]{1, 0, 1, 0, 1});
        Assert.assertEquals(1, minSwaps);
    }


    @Test
    public void minSwaps2() {
        Solution1151 solution1151 = new Solution1151();
        int minSwaps = solution1151.minSwaps(new int[]{0,0,0,1,0});
        Assert.assertEquals(0, minSwaps);
    }

    @Test
    public void minSwaps3() {
        Solution1151 solution1151 = new Solution1151();
        int minSwaps = solution1151.minSwaps(new int[]{1,0,1,0,1,0,0,1,1,0,1});
        Assert.assertEquals(3, minSwaps);
    }

    @Test
    public void minSwaps4() {
        Solution1151 solution1151 = new Solution1151();
        int minSwaps = solution1151.minSwaps(new int[]{1,0,1,0,1,0,1,1,1,0,1,0,0,1,1,1,0,0,1,1,1,0,1,0,1,1,0,0,0,1,1,1,1, 0,0,1});
        Assert.assertEquals(8, minSwaps);
    }


    @Test
    public void minSwaps5() {
        Solution1151 solution1151 = new Solution1151();
        int minSwaps = solution1151.minSwaps(new int[]{1, 0, 1, 0, 1, 1});
        Assert.assertEquals(1, minSwaps);
    }

    @Test
    public void minSwaps6() {
        Solution1151 solution1151 = new Solution1151();
        int minSwaps = solution1151.minSwaps(new int[]{1,0,1,0,1,0,1,1,1,0,1,0,0,1,1,1,0,0,1,1,1,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1});
        Assert.assertEquals(30, minSwaps);
    }
}