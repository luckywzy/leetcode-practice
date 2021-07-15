package com.code;

public class 寻找两个有序数组的中位数 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int A[] = nums1;
		int B[] = nums2;
		if (nums1.length > nums2.length) {
			A = nums2;
			B = nums1;
		}
		int m = A.length;
		int n = B.length;
		int imin = 0;
		int imax = A.length;
		int half = (m + n + 1) / 2;
		while (imin <= imax) {
			int i = (imin + imax) / 2;
			int j = half - i;


			if (i < imax && B[j - 1] > A[i]) {
				imin = i + 1;
			} else if (i > imin && A[i - 1] > B[j]) {
				imax = i - 1;
			} else {
				/*
					满足条件了
					A[i - 1] <= B[j]
					B[j - 1] <= A[i]
					接下来就是确认到底是哪个数字
				*/
				int maxLeft;
				if (i == 0) {
					maxLeft = B[j - 1];
				} else if (j == 0) {
					maxLeft = A[i - 1];
				} else {
					maxLeft = Math.max(A[i - 1], B[j - 1]);
				}
				if ((m + n) % 2 == 1) {
					return maxLeft;
				}
				int minRight;
				if (i == m) {
					minRight = B[j];
				} else if (j == n) {
					minRight = A[i];
				} else {
					minRight = Math.min(A[i], B[j]);
				}
				return (maxLeft + minRight) / 2.0;
			}
		}
		return 0.0;
	}

}
