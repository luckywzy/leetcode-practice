package com.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSortTest {

    @Test
    public void quickSort() {
        int[] arr = {5, 2, 3, 1, 4};
        new QuickSort().quickSort(arr, 0, 4);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }
}