package com.code.leetcode.editor.cn.leetcode.editor.cn;

import junit.framework.TestCase;

import java.util.Arrays;

public class Solution1Test extends TestCase {

    public void testTwoSum() {
        int[] twoSum = new Solution1().twoSum(new int[]{2, 7, 11, 15}, 9);
        Arrays.stream(twoSum).forEach(System.out::println);
    }
}