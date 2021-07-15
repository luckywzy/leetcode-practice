package com.code;

/**
 * @Author: wangzongyu
 * @Date: 2020/4/19 13:15
 */
public class LowerBound {

	public int lower(int[] nums, int key) {
		if (nums.length <= 0) {
			return -1;
		}
		int l = 0;
		int r = nums.length;
		while (l < r) {
			int mid = l + r  / 2;

			if (nums[mid] > key) {
				r = mid - 1;
			} else if (nums[mid] < key) {
				l = mid + 1;
			} else {
				return nums[mid];
			}
		}
		return nums[l];
	}
}
