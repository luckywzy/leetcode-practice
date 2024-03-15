package com.sort;

import java.util.Arrays;

/**
 * @Author: wangzongyu
 * @Date: 2020/4/19 01:01
 */
public class MergeSort {

	public void mergeSort(int[] nums, int l, int r) {
		if (l >= r){
			return;
		}
		int mid = l+(r-l)/2;
		mergeSort(nums, l, mid);
		mergeSort(nums, mid+1, r);
		int i = l;
		int j= mid+1;
		int[] help= new int[r-l+1];
		int p1=0;
		while(i <= mid && j <=r ){
			help[p1++] = nums[i ] < nums[j] ? nums[i ++] : nums[j ++];
		}
		while (i <= mid){
			help[p1 ++] = nums[i++];
		}
		while (j <=r){
			help[p1 ++] = nums[j++];
		}
		System.arraycopy(help, 0, nums, l, help.length);
	}
}
