package com.code;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: wangzongyu
 * @Date: 2019/8/18 14:56
 */
public class 盛最多水的容器Test {
	盛最多水的容器 s = new 盛最多水的容器();

	@Test
	public void maxArea1_1() {
		int[] height = {1,8,6,2,5,4,8,3,7};
		int expect = 49;
		int maxArea = s.maxArea1(height);

		Assert.assertEquals(expect, maxArea);
	}

	@Test
	public void maxArea1_2() {
		int[] height = {1,2,3};
		int expect = 2;
		int maxArea = s.maxArea1(height);

		Assert.assertEquals(expect, maxArea);
	}

	@Test
	public void maxArea2_1() {
		int[] height = {1,8,6,2,5,4,8,3,7};
		int expect = 49;
		int maxArea = s.maxArea2(height);

		Assert.assertEquals(expect, maxArea);
	}

	@Test
	public void maxArea2_2() {
		int[] height = {1,2,3};
		int expect = 2;
		int maxArea = s.maxArea2(height);

		Assert.assertEquals(expect, maxArea);
	}
}