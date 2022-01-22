package com.code.leetcode.editor.cn;

import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author wangzongyu
 * @Description:
 * @date 2022/1/6 8:17 下午
 */
public class Solution360Test extends TestCase {

    public void testSortTransformedArray() {
        Solution360 solution360 = new Solution360();
        int[] array = solution360.sortTransformedArray(new int[]{-4, -2, 2, 4}, 0, 0, 5);
        int[] exp = new int[]{5,5,5,5};
        for (int j = 0, expLength = exp.length; j < expLength; j++) {
            Assert.assertEquals(exp[j],array[j]);

        }
    }

    public void testSortTransformedArray1() {
        Solution360 solution360 = new Solution360();
        int[] array = solution360.sortTransformedArray(new int[]{-4, -2, 2, 4}, 1, 3, 5);
        int[] exp = new int[]{3,9,15,33};
        for (int j = 0, expLength = exp.length; j < expLength; j++) {
            Assert.assertEquals(exp[j],array[j]);

        }
    }
}