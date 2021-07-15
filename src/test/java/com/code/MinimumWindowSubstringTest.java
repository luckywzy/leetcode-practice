package com.code;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: wangzongyu
 * @Date: 2020/4/18 20:51
 */
public class MinimumWindowSubstringTest {

	MinimumWindowSubstring minWindow= new MinimumWindowSubstring();

	@Test
	public void minWindow1() {
		String s="aaab";
		String t= "ab";
		String result = minWindow.minWindow(s, t);
		Assert.assertEquals("ab", result);
	}
	@Test
	public void minWindow2() {
		String s="ADOBECODEBANC";
		String t= "ABC";
		String result = minWindow.minWindow(s, t);
		Assert.assertEquals("BANC", result);
	}
}