package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class Solution75Test {

    @Test
    public void sortColors() {
        int[] nums = {1, 2, 0, 0, 1, 2};
        new Solution75().sortColors(nums);
        int[] num1 = {1, 2, 0, 0, 1, 2};
        new Solution75().sortColors1(num1);
        Arrays.stream(nums).forEach(e-> System.out.print(e+","));
        System.out.println();
        Arrays.stream(num1).forEach(e-> System.out.print(e+","));
        assertArrayEquals(nums, num1);
    }

}