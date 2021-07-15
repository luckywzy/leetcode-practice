package com.code;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: wangzongyu
 * @Date: 2019/7/5 21:08
 */
public class 最长回文子串Test {

	@Test
	public void longestPalindrome1() {
		最长回文子串 a = new 最长回文子串();
		String s = "ababa";
		String res = a.longestPalindrome(s);
		Assert.assertEquals(s, res);
	}

	@Test
	public void longestPalindrome2() {
		最长回文子串 a = new 最长回文子串();
		String s = "abba";
		String res = a.longestPalindrome(s);
		Assert.assertEquals(s, res);
	}

	@Test
	public void longestPalindrome3() {
		最长回文子串 a = new 最长回文子串();
		String s = "a";
		String res = a.longestPalindrome(s);
		Assert.assertEquals(s, res);
	}
	@Test
	public void longestPalindrome3_1() {
		最长回文子串 a = new 最长回文子串();
		String s = "ab";
		String res = a.longestPalindrome(s);
		Assert.assertEquals("a", res);
	}

	@Test
	public void longestPalindrome4() {
		最长回文子串 a = new 最长回文子串();
		String s = "abcdefghgabcd";
		String res = a.longestPalindrome(s);
		Assert.assertEquals("ghg", res);
	}

	@Test
	public void longestPalindrome5() {
		最长回文子串 a = new 最长回文子串();
		String s = "babad";
		String res = a.longestPalindrome(s);
		Assert.assertEquals("bab", res);
	}
	@Test
	public void longestPalindrome6() {
		最长回文子串 a = new 最长回文子串();
		String s = "ccc";
		String res = a.longestPalindrome(s);
		Assert.assertEquals("ccc", res);
	}
	@Test
	public void longestPalindrome7() {
		最长回文子串 a = new 最长回文子串();
		String s = "aaaa";
		String res = a.longestPalindrome(s);
		Assert.assertEquals("aaaa", res);
	}
}