package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Solution31Test {

    @Test
    public void nextPermutation() {
        int[] nums = new int[]{1, 2, 3};
        new Solution31().nextPermutation(nums);
        Arrays.stream(nums).forEach(e -> System.out.print(e + ","));
    }

    @Test
    public void nextPermutation_1() {
        int[] nums = new int[]{3,2,1};
        new Solution31().nextPermutation(nums);
        Arrays.stream(nums).forEach(e -> System.out.print(e + ","));
    }
    @Test
    public void nextPermutation_2() {
        int[] nums = new int[]{1,1,5};
        new Solution31().nextPermutation(nums);
        Arrays.stream(nums).forEach(e -> System.out.print(e + ","));
    }
}