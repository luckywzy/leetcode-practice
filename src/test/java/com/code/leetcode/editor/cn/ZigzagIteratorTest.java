package com.code.leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/11/8 8:30 下午
 */
public class ZigzagIteratorTest {

    @Test
    public void next() {
        Integer[] v1 = new Integer[]{1, 2};
        Integer[] v2 = new Integer[]{3, 4, 5, 6};
        ZigzagIterator zigzagIterator = new ZigzagIterator(Arrays.asList(v1), Arrays.asList(v2));
        //  [1,3,2,4,5,6]
        while (zigzagIterator.hasNext()) {
            System.out.print(zigzagIterator.next() + ",");
        }
    }


    @Test
    public void next1() {
        Integer[] v1 = new Integer[]{1, 3};
        Integer[] v2 = new Integer[]{2, 4, 5};
        ZigzagIterator zigzagIterator = new ZigzagIterator(Arrays.asList(v1), Arrays.asList(v2));
        //  [1,3,2,4,5,6]
        while (zigzagIterator.hasNext()) {
            System.out.print(zigzagIterator.next() + ",");
        }
    }

    @Test
    public void next3() {
        Integer[] v1 = new Integer[]{1};
        Integer[] v2 = new Integer[]{5};
        ZigzagIterator zigzagIterator = new ZigzagIterator(Arrays.asList(v1), Arrays.asList(v2));
        //  [1,3,2,4,5,6]
        while (zigzagIterator.hasNext()) {
            System.out.print(zigzagIterator.next() + ",");
        }
    }
}