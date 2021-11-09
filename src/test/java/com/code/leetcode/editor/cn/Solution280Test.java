package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/11/8 7:58 下午
 */
public class Solution280Test {

    @Test
    public void wiggleSort() {
        Solution280 solution280 = new Solution280();
        int[] in = {3,5,2,1,6,4};
        solution280.wiggleSort(in);

        System.out.println(Arrays.toString(in));
    }

    @Test
    public void wiggleSort1_0() {
        Solution280 solution280 = new Solution280();
        int[] in = {3,5,2,1,6,4};
        solution280.wiggleSort1(in);

        System.out.println(Arrays.toString(in));
    }

    @Test
    public void wiggleSort2_0() {
        Solution280 solution280 = new Solution280();
        int[] in = {3,5,2,1,6,4};
        solution280.wiggleSort2(in);

        System.out.println(Arrays.toString(in));
    }

    @Test
    public void wiggleSort3_0() {
        Solution280 solution280 = new Solution280();
        int[] in = {3,5,2,1,6,4};
        solution280.wiggleSort3(in);

        System.out.println(Arrays.toString(in));
    }
}