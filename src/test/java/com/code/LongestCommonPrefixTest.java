package com.code;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: wangzongyu
 * @Date: 2020/3/11 20:25
 */
public class LongestCommonPrefixTest {

	LongestCommonPrefix  longestCommonPrefix= new LongestCommonPrefix();
	@Test
	public void longestCommonPrefix() {
		String[] strs = new String[3];
		strs[0] = "flower";
		strs[1] = "flow";
		strs[2] = "flight";
		String res = longestCommonPrefix.longestCommonPrefix1(strs);
		Assert.assertEquals("fl", res);
	}

	@Test
	public void longestCommonPrefix1() {
		String[] strs = new String[3];
		strs[0] = "dog";
		strs[1] = "cat";
		strs[2] = "car";
		String res = longestCommonPrefix.longestCommonPrefix1(strs);
		Assert.assertEquals("", res);
	}

	@Test
	public void longestCommonPrefix2() {
		String[] strs = new String[0];
		String res = longestCommonPrefix.longestCommonPrefix1(strs);
		Assert.assertEquals("", res);
	}


	@Test
	public void longestCommonPrefix3() {
		String[] strs = null;
		String res = longestCommonPrefix.longestCommonPrefix1(strs);
		Assert.assertEquals("", res);
	}

	@Test
	public void longestCommonPrefix4() {
		String[] strs = new String[1];
		strs[0] = "ancd";
		String res = longestCommonPrefix.longestCommonPrefix1(strs);
		Assert.assertEquals("ancd", res);
	}

	@Test
	public void longestCommonPrefix5() {
		String[] strs = new String[2];
		strs[0] = "";
		strs[1] = "";
		String res = longestCommonPrefix.longestCommonPrefix1(strs);
		Assert.assertEquals("", res);
	}
	@Test
	public void longestCommonPrefix8() {
		String[] strs = new String[2];
		strs[0] = "a";
		strs[1] = "a";
		String res = longestCommonPrefix.longestCommonPrefix1(strs);
		Assert.assertEquals("a", res);
	}

	@Test
	public void longestCommonPrefix10() {
		String[] strs = new String[2];
		strs[0] = "a";
		strs[1] = "aa";
		String res = longestCommonPrefix.longestCommonPrefix1(strs);
		Assert.assertEquals("a", res);
	}

	@Test
	public void longestCommonPrefix11() {
		String[] strs = new String[2];
		strs[0] = "aa";
		strs[1] = "a";
		String res = longestCommonPrefix.longestCommonPrefix1(strs);
		Assert.assertEquals("a", res);
	}


	@Test
	public void longestCommonPrefix6() {
		String[] strs = new String[2];
		strs[0] = "";
		strs[1] = "eqwe";
		String res = longestCommonPrefix.longestCommonPrefix1(strs);
		Assert.assertEquals("", res);
	}


	@Test
	public void longestCommonPrefix7() {
		String[] strs = new String[2];
		strs[0] = "qqq";
		strs[1] = "qqq";
		String res = longestCommonPrefix.longestCommonPrefix1(strs);
		Assert.assertEquals("qqq", res);
	}

	@Test
	public void longestCommonPrefix12() {
		String[] strs = new String[2];
		strs[0] = "aca";
		strs[1] = "cba";
		String res = longestCommonPrefix.longestCommonPrefix1(strs);
		Assert.assertEquals("", res);
	}
}