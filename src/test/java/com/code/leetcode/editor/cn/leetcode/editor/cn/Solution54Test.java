package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution54Test {

    @Test
    public void spiralOrder() {
        List<Integer> list = new Solution54().spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        list.forEach(e -> System.out.print(e + ","));
    }

    @Test
    public void spiralOrder2() {
        List<Integer> list = new Solution54().spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        });
        list.forEach(e -> System.out.print(e + ","));
    }

    @Test
    public void spiralOrder3() {
        List<Integer> list = new Solution54().spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        });
        list.forEach(e -> System.out.print(e + ","));
    }
}