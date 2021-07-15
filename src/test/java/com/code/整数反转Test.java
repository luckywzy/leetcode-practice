package com.code;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: wangzongyu
 * @Date: 2019/7/20 15:40
 */
public class 整数反转Test {

	整数反转 solution = new 整数反转();

	@Test
	public void reverse1() {
		int n = 1234567;
		int rev = 7654321;
		Assert.assertEquals(rev, solution.reverse(n));
	}

	@Test
	public void reverse2() {
		int n = 1234567890;
		int rev = 987654321;
		Assert.assertEquals(rev, solution.reverse(n));
	}

	@Test
	public void reverse3() {
		int n = 0;
		int rev = 0;
		Assert.assertEquals(rev, solution.reverse(n));
	}

	@Test
	public void reverse4() {
		int n = -1234567890;
		int rev = -987654321;
		Assert.assertEquals(rev, solution.reverse(n));
	}
}