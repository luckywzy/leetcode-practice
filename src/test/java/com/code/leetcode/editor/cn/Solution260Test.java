package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/7/19 2:32 下午
 */
public class Solution260Test {

    @Test
    public void singleNumber() {
        Solution260 solution260 = new Solution260();

        Assert.assertArrayEquals(new int[]{3, 5}, solution260.singleNumber(new int[]{1, 2, 1, 3, 2, 5}));
        Assert.assertArrayEquals(new int[]{-1, 0}, solution260.singleNumber(new int[]{-1, 0}));
        Assert.assertArrayEquals(new int[]{0, 1}, solution260.singleNumber(new int[]{0, 1}));
    }
}