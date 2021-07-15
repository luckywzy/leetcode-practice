package com.code;

/**
 * https://leetcode-cn.com/problems/candy/
 *
 * @Author: wangzongyu
 * @Date: 2020/4/18 17:57
 */
public class Candy {

	public int candy(int[] ratings) {
		if (ratings.length < 2) {
			return ratings.length;
		}
		int[] reward = new int[ratings.length];
		for (int i = 0; i < ratings.length; i++) {
			reward[i] = 1;
		}

		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i - 1] < ratings[i]) {
				reward[i] = reward[i - 1] + 1;
			}
		}

		for (int i = ratings.length - 1; i > 0; i--) {
			if (ratings[i - 1] > ratings[i]) {
				reward[i - 1] = Math.max(reward[i - 1], reward[i] + 1);
			}
		}
		int sum = 0;
		for (int i = 0; i < ratings.length; i++) {
			sum += reward[i];
		}
		return sum;
	}
}
