package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2022/1/3 10:07 下午
 */
public class Solution323Test {

    @Test
    public void countComponents() {
        //[[0, 1], [1, 2], [3, 4]]
        int[][] edgs = {
                {0, 1}, {1, 2}, {3, 4}
        };
        Solution323 solution323 = new Solution323();
        Assert.assertEquals(2, solution323.countComponents(5, edgs));
    }

    @Test
    public void countComponents1() {
        //[[0, 1], [1, 2], [2, 3], [3, 4]]
        int[][] edgs = {
                {0, 1}, {1, 2}, {2, 3}, {3, 4}
        };
        Solution323 solution323 = new Solution323();
        Assert.assertEquals(1, solution323.countComponents(5, edgs));
    }

    @Test
    public void countComponents2() {
        //[[0, 1], [1, 2], [3, 4]]
        int[][] edgs = {
                {0, 1}, {1, 2}, {3, 4}
        };
        Solution323 solution323 = new Solution323();
        Assert.assertEquals(2, solution323.countComponents1(5, edgs));
    }

    @Test
    public void countComponents3() {
        //[[0, 1], [1, 2], [2, 3], [3, 4]]
        int[][] edgs = {
                {0, 1}, {1, 2}, {2, 3}, {3, 4}
        };
        Solution323 solution323 = new Solution323();
        Assert.assertEquals(1, solution323.countComponents1(5, edgs));
    }

    @Test
    public void countComponents4() {
        //[[2,3],[1,2],[1,3]]
        int[][] edgs = {
                {2, 3}, {1, 2}, {1, 3}
        };
        Solution323 solution323 = new Solution323();
        Assert.assertEquals(2, solution323.countComponents1(4, edgs));
    }

    @Test
    public void countComponents7() {
        //[[0, 1], [1, 2], [3, 4]]
        int[][] edgs = {
                {0, 1}, {1, 2}, {3, 4}
        };
        Solution323 solution323 = new Solution323();
        Assert.assertEquals(2, solution323.countComponents2(5, edgs));
    }

    @Test
    public void countComponents5() {
        //[[0, 1], [1, 2], [2, 3], [3, 4]]
        int[][] edgs = {
                {0, 1}, {1, 2}, {2, 3}, {3, 4}
        };
        Solution323 solution323 = new Solution323();
        Assert.assertEquals(1, solution323.countComponents2(5, edgs));
    }

    @Test
    public void countComponents6() {
        //[[2,3],[1,2],[1,3]]
        int[][] edgs = {
                {2, 3}, {1, 2}, {1, 3}
        };
        Solution323 solution323 = new Solution323();
        Assert.assertEquals(2, solution323.countComponents2(4, edgs));
    }
}