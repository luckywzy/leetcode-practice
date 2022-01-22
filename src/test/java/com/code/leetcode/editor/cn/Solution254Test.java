package com.code.leetcode.editor.cn;


import org.junit.Test;

import java.util.List;

/**
 * @author wangzongyu
 * @Description:
 * @date 2022/1/20 2:53 下午
 */
public class Solution254Test {

    @Test
    public void getFactors0() {
        Solution254 solution254 = new Solution254();
        List<List<Integer>> factors = solution254.getFactors(8);
        for (List<Integer> factor : factors) {
            for (Integer f : factor) {
                System.out.print(f + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void getFactors() {
        Solution254 solution254 = new Solution254();
        List<List<Integer>> factors = solution254.getFactors(12);
        for (List<Integer> factor : factors) {
            for (Integer f : factor) {
                System.out.print(f + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void getFactors2() {
        Solution254 solution254 = new Solution254();
        List<List<Integer>> factors = solution254.getFactors(32);
        for (List<Integer> factor : factors) {
            for (Integer f : factor) {
                System.out.print(f + " ");
            }
            System.out.println();
        }
    }
}