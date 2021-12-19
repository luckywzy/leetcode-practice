package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/12/19 1:34 下午
 */
public class Solution296Test {

    @Test
    public void minTotalDistance() {
        Solution296 solution296 = new Solution296();
        Assert.assertEquals(6, solution296.minTotalDistance(new int[][]{
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}
        }));
        ;
    }

    @Test
    public void minTotalDistance2() {
        Solution296 solution296 = new Solution296();
        Assert.assertEquals(6, solution296.minTotalDistance2(new int[][]{
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}
        }));
        ;
    }
}