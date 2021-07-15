package com.code;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: wangzongyu
 * @Date: 2020/4/19 13:24
 */
public class LowerBoundTest {
	LowerBound lowerBound = new LowerBound();

	@Test
	public void lower() {
		int[] nums={1,3,5,7,8};
		int key = 6;
		int lower = lowerBound.lower(nums, key);
		Assert.assertEquals(7, lower);
	}
}