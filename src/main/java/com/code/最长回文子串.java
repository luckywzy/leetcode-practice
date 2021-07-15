package com.code;

/**
 * @Author: wangzongyu
 * @Date: 2019/7/5 20:52
 */
public class 最长回文子串 {
	public String longestPalindrome(String s) {
		if (s == null || s.length() < 1) {
			return "";
		}
		if (s.length() == 1) {
			return s;
		}
		int i = 1;
		int size = s.length();
		String res = s.substring(0, 1);
		while (i < size) {
			if ((i + 1 < size) && (s.charAt(i - 1) == s.charAt(i + 1))) {
				String r2 = calPalindrome(s, i - 1, i + 1, size);
				if (r2.length() > res.length()) {
					res = r2;
				}
			}
			if (s.charAt(i) == s.charAt(i - 1)) {
				String r1 = calPalindrome(s, i - 1, i, size);
				if (r1.length() > res.length()) {
					res = r1;
				}
			}
			i++;
		}
		return res;
	}

	//回文判断
	private String calPalindrome(String s, int low, int high, int size) {
		while (low >= 0 && high < size && s.charAt(low) == s.charAt(high)) {
			low--;
			high++;
		}
		return s.substring(low + 1, high);
	}
}
