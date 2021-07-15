package com.code;

import org.junit.Test;

import java.util.List;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/6/25 10:09 下午
 */
public class Solution254Test {

    @Test
    public void getFactors() {

        Solution254 solution254 = new Solution254();
        List<List<Integer>> factors = solution254.getFactors(8);
        System.out.println(factors);
    }

    @Test
    public void getFactors1() {

        Solution254 solution254 = new Solution254();
        List<List<Integer>> factors = solution254.getFactors(12);
        System.out.println(factors);
    }

    @Test
    public void getFactors2() {

        Solution254 solution254 = new Solution254();
        List<List<Integer>> factors = solution254.getFactors(32);
        System.out.println(factors);
    }

    @Test
    public void getFactors3() {

        Solution254 solution254 = new Solution254();
        List<List<Integer>> factors = solution254.getFactors(37);
        System.out.println(factors);
    }
}