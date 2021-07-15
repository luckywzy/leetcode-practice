package com.code;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: wangzongyu
 * @Date: 2019/4/17 19:48
 */
public class 无重复字符的最长子串Test {

	@Test
	public void lengthOfLongestSubstring() {
		String s = "abcabcbb";
		无重复字符的最长子串 t1 = new 无重复字符的最长子串();
		int length = t1.lengthOfLongestSubstring(s);
		assertEquals(3, length);
	}

	@Test
	public void lengthOfLongestSubstring2() {
		String s = "bbbbb";
		无重复字符的最长子串 t1 = new 无重复字符的最长子串();
		int length = t1.lengthOfLongestSubstring(s);
		assertEquals(1, length);
	}


	@Test
	public void lengthOfLongestSubstring3() {
		String s = "pwwkew";
		无重复字符的最长子串 t1 = new 无重复字符的最长子串();
		int length = t1.lengthOfLongestSubstring(s);
		assertEquals(3, length);
	}
	@Test
	public void lengthOfLongestSubstring4() {
		String s = "abcdefgh";
		无重复字符的最长子串 t1 = new 无重复字符的最长子串();
		int length = t1.lengthOfLongestSubstring(s);
		assertEquals(8, length);
	}

	@Test
	public void lengthOfLongestSubstring5() {
		String s = "dvdf";
		无重复字符的最长子串 t1 = new 无重复字符的最长子串();
		int length = t1.lengthOfLongestSubstring(s);
		assertEquals(3, length);
	}
	@Test
	public void lengthOfLongestSubstring6() {
		String s = "nfpdmpi";
		无重复字符的最长子串 t1 = new 无重复字符的最长子串();
		int length = t1.lengthOfLongestSubstring(s);
		assertEquals(5, length);
	}
	@Test
	public void lengthOfLongestSubstring7() {
		String s = "tmmzuxt";
		无重复字符的最长子串 t1 = new 无重复字符的最长子串();
		int length = t1.lengthOfLongestSubstring(s);
		assertEquals(5, length);
	}
	@Test
	public void lengthOfLongestSubstring8() {
		String s = "aabaab!bb";
		无重复字符的最长子串 t1 = new 无重复字符的最长子串();
		int length = t1.lengthOfLongestSubstring(s);
		assertEquals(3, length);
	}
}