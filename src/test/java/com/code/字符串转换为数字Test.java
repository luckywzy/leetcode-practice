package com.code;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: wangzongyu
 * @Date: 2019/7/20 16:25
 */
public class 字符串转换为数字Test {
	字符串转换为数字 solution = new 字符串转换为数字();

	@Test
	public void myAtoi1() {
		String in = "-42";
		int out = -42;
		Assert.assertEquals(out, solution.myAtoi(in));
	}

	@Test
	public void myAtoi2() {
		String in = "-42xxx";
		int out = -42;
		Assert.assertEquals(out, solution.myAtoi(in));
	}

	@Test
	public void myAtoi3() {
		String in = "   -42   ";
		int out = -42;
		Assert.assertEquals(out, solution.myAtoi(in));
	}

	@Test
	public void myAtoi4() {
		String in = "xxx -42";
		int out = 0;
		Assert.assertEquals(out, solution.myAtoi(in));
	}

	@Test
	public void myAtoi5() {
		String in = "xxx 42";
		int out = 0;
		Assert.assertEquals(out, solution.myAtoi(in));
	}

	@Test
	public void myAtoi6() {
		String in = "-9089078y77867";
		int out = -9089078;
		Assert.assertEquals(out, solution.myAtoi(in));
	}
	@Test
	public void myAtoi7() {
		String in = "-9876543210";
		int out = -2147483648;
		Assert.assertEquals(out, solution.myAtoi(in));
	}
	@Test
	public void myAtoi8() {
		String in = "2147483648";
		int out = 2147483647;
		Assert.assertEquals(out, solution.myAtoi(in));
	}
}