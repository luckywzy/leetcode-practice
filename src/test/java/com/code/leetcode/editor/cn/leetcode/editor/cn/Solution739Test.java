package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Solution739Test {

    @Test
    public void dailyTemperatures() {
        int[] dailyTemperatures = new Solution739().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        Arrays.stream(dailyTemperatures).forEach(e-> System.out.print(e + ","));
    }
    @Test
    public void dailyTemperatures1() {
        int[] dailyTemperatures = new Solution739().dailyTemperatures(new int[]{3,4,5,6});
        Arrays.stream(dailyTemperatures).forEach(e-> System.out.print(e + ","));
    }
}