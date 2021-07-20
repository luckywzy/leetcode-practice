package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/7/20 4:51 下午
 */
public class Solution265Test {

    @Test
    public void minCostII() {
        Solution265 solution265 = new Solution265();
        Assert.assertEquals(5, solution265.minCostII(new int[][]{{1, 5, 3}, {2, 9, 4}}));
    }

    @Test
    public void minCostII2() {
        Solution265 solution265 = new Solution265();
        Assert.assertEquals(41, solution265.minCostII(new int[][]{
                {10, 15, 12, 14, 18, 5},
                {5, 12, 18, 13, 15, 8},
                {4, 7, 4, 2, 10, 18},
                {20, 9, 9, 19, 20, 5},
                {10, 15, 10, 15, 16, 20},
                {9, 6, 11, 10, 12, 11},
                {7, 10, 6, 12, 20, 8},
                {3, 4, 4, 18, 10, 2}}));
    }

    @Test
    public void minCostII21() {
        Solution265 solution265 = new Solution265();
        Assert.assertEquals(41, solution265.minCostII2(new int[][]{
                {10, 15, 12, 14, 18, 5},
                {5, 12, 18, 13, 15, 8},
                {4, 7, 4, 2, 10, 18},
                {20, 9, 9, 19, 20, 5},
                {10, 15, 10, 15, 16, 20},
                {9, 6, 11, 10, 12, 11},
                {7, 10, 6, 12, 20, 8},
                {3, 4, 4, 18, 10, 2}}));
    }
}