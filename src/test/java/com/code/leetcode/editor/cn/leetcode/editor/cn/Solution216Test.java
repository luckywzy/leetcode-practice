package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution216Test {

    @Test
    public void combinationSum3() {
        List<List<Integer>> combine = new Solution216().combinationSum3(3, 7);
        // [[1,2,4]]
        combine.forEach(e -> {
            e.forEach(x -> System.out.print(x + ","));
            System.out.println();
        });
    }

    @Test
    public void combinationSum3_1() {
        List<List<Integer>> combine = new Solution216().combinationSum3(3, 9);
        // [[1,2,6], [1,3,5], [2,3,4]]
        combine.forEach(e -> {
            e.forEach(x -> System.out.print(x + ","));
            System.out.println();
        });
    }

    @Test
    public void combinationSum3_2() {
        List<List<Integer>> combine = new Solution216().combinationSum3(4, 1);
        // []
        combine.forEach(e -> {
            e.forEach(x -> System.out.print(x + ","));
            System.out.println();
        });
    }
}