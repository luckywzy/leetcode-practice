package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2022/1/16 4:18 下午
 */
public class Solution300Test {

    @Test
    public void lengthOfLIS() {
        Solution300 solution300 = new Solution300();
        int lengthOfLIS = solution300.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        Assert.assertEquals(4, lengthOfLIS);
    }

    @Test
    public void lengthOfLIS1() {
        Solution300 solution300 = new Solution300();
        int lengthOfLIS = solution300.lengthOfLIS(new int[]{0,1,0,3,2,3});
        Assert.assertEquals(4, lengthOfLIS);
    }
    @Test
    public void lengthOfLIS2() {
        Solution300 solution300 = new Solution300();
        int lengthOfLIS = solution300.lengthOfLIS(new int[]{7,7,7,7,7,7,7});
        Assert.assertEquals(1, lengthOfLIS);
    }
}