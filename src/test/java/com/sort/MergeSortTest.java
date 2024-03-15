package com.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortTest {

    @Test
    public void mergeSort() {
        int[] arr = new int[]{5,2,3,1,4};
        new MergeSort().mergeSort(arr, 0, arr.length-1);
        assertArrayEquals(new int[]{1,2,3,4,5}, arr);
    }

    @Test
    public void mergeSort1() {
        int[] arr = new int[]{5,1,6,2,5};
        new MergeSort().mergeSort(arr, 0, arr.length-1);
        assertArrayEquals(new int[]{1,2,5,5,6}, arr);
    }
}