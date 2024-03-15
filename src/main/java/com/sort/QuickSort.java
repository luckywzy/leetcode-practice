package com.sort;

/**
 * @Author: wangzongyu
 * @Date: 2020/4/19 00:44
 */
public class QuickSort {

	void quickSort(int[] nums, int low, int high){
		if (low >= high){
			return;
		}
		int key = nums[low];
		int i=low;
		int j=high;
		while (i < j){
			while (i < j && nums[j] >= key){
				j--;
			}
			swap(nums, i, j);
			while (i< j && nums[i] <= key){
				i++;
			}
			swap(nums, i, j);
		}
		quickSort(nums, low, i-1);
		quickSort(nums, i+1, high);
	}

	private void swap(int[] arr, int i , int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
