package com.code;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: wangzongyu
 * @Date: 2019/7/21 13:43
 */
public class 正则表达式匹配Test {
	正则表达式匹配 solution = new 正则表达式匹配();

	@Test
	public void isMatch() {
		String in = "aa";
		String pattern = "a";
		boolean res = false;
		Assert.assertEquals(res, solution.isMatch(in, pattern));
	}

	@Test
	public void isMatch2() {
		String in = "aa";
		String pattern = "a*";
		boolean res = true;
		Assert.assertEquals(res, solution.isMatch(in, pattern));
	}

	@Test
	public void isMatch3() {
		String in = "abcdefg";
		String pattern = ".*";
		boolean res = true;
		Assert.assertEquals(res, solution.isMatch(in, pattern));
	}

	@Test
	public void isMatch4() {
		String in = "";
		String pattern = "*";
		boolean res = false;
		Assert.assertEquals(res, solution.isMatch(in, pattern));
	}

	@Test
	public void isMatch5() {
		String in = "ab";
		String pattern = ".";
		boolean res = false;
		Assert.assertEquals(res, solution.isMatch(in, pattern));
	}

	@Test
	public void isMatch6() {
		String in = "aab";
		String pattern = "c*a*b";
		boolean res = true;
		Assert.assertEquals(res, solution.isMatch(in, pattern));
	}

	@Test
	public void isMatch7() {
		String in = "mississippi";
		String pattern = "mis*is*p*.";
		boolean res = false;
		Assert.assertEquals(res, solution.isMatch(in, pattern));
	}

	@Test
	public void isMatch8() {
		String in = "ab";
		String pattern = ".*c";
		boolean res = false;
		Assert.assertEquals(res, solution.isMatch(in, pattern));
	}

	@Test
	public void isMatch9() {
		String in = "aaa";
		String pattern = "aaaa";
		boolean res = false;
		Assert.assertEquals(res, solution.isMatch(in, pattern));
	}


	@Test
	public void isMatch10() {
		String in = "aaa";
		String pattern = "aaaa*";
		boolean res = true;
		Assert.assertEquals(res, solution.isMatch(in, pattern));
	}

	@Test
	public void isMatch11() {
		String in = "aaa";
		String pattern = "a*a";
		boolean res = true;
		Assert.assertEquals(res, solution.isMatch(in, pattern));
	}

	@Test
	public void isMatch12() {
		String in = "aaa";
		String pattern = "ab*a*c*a";
		boolean res = true;
		Assert.assertEquals(res, solution.isMatch(in, pattern));
	}
}