package com.code;

/**
 * 官方题解已经写的很好了
 *
 * @Author: wangzongyu
 * @Date: 2019/8/18 14:52
 */
public class 盛最多水的容器 {
	/**
	 * 暴力法
	 * @param height
	 * @return
	 */
	public int maxArea1(int[] height) {
		int maxArea = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
			}
		}
		return maxArea;
	}

	/**
	 * 双指针法
	 * 每次移动值较小的位置，这样可以保证最大的区间不会被漏掉
	 * 具体证明见：https://leetcode-cn.com/problems/container-with-most-water/solution/shuang-zhi-zhen-fa-zheng-que-xing-zheng-ming-by-r3/
	 *
	 * @param height
	 * @return
	 */
	public int maxArea2(int[] height) {
		int low = 0;
		int high = height.length - 1;
		int maxArea = 0;
		while (low < high) {
			maxArea = Math.max(maxArea, Math.min(height[low], height[high]) * (high - low));
			if (height[low] < height[high]) {
				low++;
			} else {
				high--;
			}
		}

		return maxArea;
	}
}
