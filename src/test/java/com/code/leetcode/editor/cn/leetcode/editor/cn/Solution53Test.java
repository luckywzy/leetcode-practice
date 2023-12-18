package com.code.leetcode.editor.cn.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution53Test {

    @Test
    public void maxSubArray() {
        int maxSubArray = new Solution53().maxSubArray_force(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        assertEquals(6,maxSubArray);
    }

    @Test
    public void maxSubArray_1() {
        int maxSubArray = new Solution53().maxSubArray_force(new int[]{5,4,-1,7,8});
        assertEquals(23,maxSubArray);
    }

    @Test
    public void maxSubArray_2() {
        int maxSubArray = new Solution53().maxSubArray_force(new int[]{1});
        assertEquals(1,maxSubArray);
    }

    @Test
    public void maxSubArray1_1() {
        int maxSubArray = new Solution53().maxSubArray_1(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        assertEquals(6,maxSubArray);
    }

    @Test
    public void maxSubArray1_2() {
        int maxSubArray = new Solution53().maxSubArray_1(new int[]{5,4,-1,7,8});
        assertEquals(23,maxSubArray);
    }

    @Test
    public void maxSubArray1_3() {
        int maxSubArray = new Solution53().maxSubArray_1(new int[]{1});
        assertEquals(1,maxSubArray);
    }

    @Test
    public void maxSubArray2_1() {
        int maxSubArray = new Solution53().maxSubArray_2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        assertEquals(6,maxSubArray);
    }

    @Test
    public void maxSubArray2_2() {
        int maxSubArray = new Solution53().maxSubArray_2(new int[]{5,4,-1,7,8});
        assertEquals(23,maxSubArray);
    }

    @Test
    public void maxSubArray2_3() {
        int maxSubArray = new Solution53().maxSubArray_2(new int[]{1});
        assertEquals(1,maxSubArray);
    }
}