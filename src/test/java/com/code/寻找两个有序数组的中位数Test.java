package com.code;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class 寻找两个有序数组的中位数Test {

	寻找两个有序数组的中位数 p = new 寻找两个有序数组的中位数();

	@Test
	public void findMedianSortedArrays1() {
		int A[] = {1, 3};
		int B[] = {2};
		double medianSortedArrays = p.findMedianSortedArrays(A, B);
		double ex = 2.0;
		assertEquals(ex, medianSortedArrays, 0.0);
	}

	@Test
	public void findMedianSortedArrays2() {
		int A[] = {1, 2};
		int B[] = {3, 4};
		double medianSortedArrays = p.findMedianSortedArrays(A, B);
		double ex = 2.5;
		assertEquals(ex, medianSortedArrays, 0.0);
	}

	@Test
	public void findMedianSortedArrays3() {
		int A[] = {1, 3};
		int B[] = {};
		double medianSortedArrays = p.findMedianSortedArrays(A, B);
		double ex = 2.0;
		assertEquals(ex, medianSortedArrays, 0.0);
	}

	@Test
	public void findMedianSortedArrays4() {
		int A[] = {};
		int B[] = {1, 3};
		double medianSortedArrays = p.findMedianSortedArrays(A, B);
		double ex = 2.0;
		assertEquals(ex, medianSortedArrays, 0.0);

	}
}