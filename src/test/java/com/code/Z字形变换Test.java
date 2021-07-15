package com.code;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: wangzongyu
 * @Date: 2019/7/14 14:44
 */
public class Z字形变换Test {
	Z字形变换 sulotion = new Z字形变换();
	@Test
	public void convert1() {
		String s = "LEETCODEISHIRING";
		int numRows = 3;
		String res = "LCIRETOESIIGEDHN";
		Assert.assertEquals(res, sulotion.convert(s,numRows));
	}

	@Test
	public void convert2() {
		String s = "LEETCODEISHIRING";
		int numRows = 4;
		String res = "LDREOEIIECIHNTSG";
		Assert.assertEquals(res, sulotion.convert(s,numRows));
	}

	@Test
	public void convert3() {
		String s = "";
		int numRows = 2;
		String res = "";
		Assert.assertEquals(res, sulotion.convert(s,numRows));
	}

	@Test
	public void convert4() {
		String s = "acb";
		int numRows = 2;
		String res = "abc";
		Assert.assertEquals(res, sulotion.convert(s,numRows));
	}

	@Test
	public void convert5() {
		String s = "a";
		int numRows = 1;
		String res = "a";
		Assert.assertEquals(res, sulotion.convert(s,numRows));
	}

	@Test
	public void convert6() {
		String s = "aaaaaaaa";
		int numRows = 1;
		String res = "aaaaaaaa";
		Assert.assertEquals(res, sulotion.convert(s,numRows));
	}
}