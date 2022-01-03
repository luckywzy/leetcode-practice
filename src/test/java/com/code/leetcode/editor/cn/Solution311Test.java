package com.code.leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/12/23 2:54 下午
 */
public class Solution311Test {

    @Test
    public void multiply() {
        Solution311 solution311 = new Solution311();
        int[][] multiply = solution311.multiply(new int[][]{
                        {1, 0, 0},
                        {-1, 0, 3}
                },
                new int[][]{
                        {7, 0, 0},
                        {0, 0, 0},
                        {0, 0, 1}
                });
        System.out.println(Arrays.deepToString(multiply));
    }

    @Test
    public void multiply1() {
        Solution311 solution311 = new Solution311();
        int[][] multiply = solution311.multiply(new int[][]{
                        {1, -5},
                },
                new int[][]{
                        {12},
                        {-1},
                });
        //[[17]]
        System.out.println(Arrays.deepToString(multiply));
    }
}