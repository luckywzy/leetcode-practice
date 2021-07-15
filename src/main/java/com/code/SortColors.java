package com.code;

/**
 * 题目:颜色分类 URL：https://leetcode-cn.com/problems/sort-colors/
 * 熟悉各种排序算法的性质就没有问题了
 * 解法 ：
 *
 * 1：使用桶排序
 * 2：使用原地且稳定的排序算法:冒泡或者插入
 *
 *
 * @Author: wangzongyu
 * @Date: 2019/8/25 14:07
 */
public class SortColors {
	/**
	 * 非原地的排序
	 *
	 * @param nums
	 */
	public void sortColors1(int[] nums) {
		int[] redBuck = new int[nums.length];
		int[] writeBuck = new int[nums.length];
		int[] blueBuck = new int[nums.length];
		int r = 0, w = 0, b = 0;
		for (int num : nums) {
			//记录值
			if (num == 0) {
				redBuck[r++] = 0;
			} else if (num == 1) {
				writeBuck[w++] = 1;
			} else {
				blueBuck[b++] = 2;
			}
		}
		if (r > 0) System.arraycopy(redBuck, 0, nums, 0, r);
		if (w > 0) System.arraycopy(writeBuck, 0, nums, r, w);
		if (b > 0) System.arraycopy(blueBuck, 0, nums, r + w, b);

	}

	/**
	 * 原地排序算法有：冒泡、插入和选择
	 * 但是稳定的排序算法只有冒泡和插入
	 *
	 * @param nums
	 */
	public void sortColors2(int[] nums) {
		bubbleSort(nums);
	}


	/**
	 * 冒泡排序
	 *
	 * @param nums
	 */
	public void bubbleSort(int[] nums) {
		//使用冒泡
		for (int i = 0; i < nums.length; i++) {
			boolean swaped = false;
			//每经过一轮，待排区间会减小
			for (int j = 0; j < nums.length - i - 1; j++) {
				if (nums[j] > nums[j + 1]) { //交换数据
					int tmp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = tmp;
					swaped = true; //标识有数据交换
				}
			}
			if (!swaped) { //没有数据交换，可以提前退出
				break;
			}
		}
	}


	public void sortColors3(int[] nums) {
		insertionSort(nums);
	}
	/**
	 * 插入排序
	 *
	 * @param nums
	 */
	public void insertionSort(int[] nums) {

		for (int i = 1; i < nums.length; i++) {
			int val = nums[i];
			int j = i - 1;
			for (; j >= 0; j--) {
				if (nums[j] > val) {
					nums[j + 1] = nums[j]; //移动数据
				}else {
					break;
				}
			}
			nums[j+1] = val; //插入数据
		}
	}


}
