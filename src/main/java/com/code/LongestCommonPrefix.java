package com.code;

/**
 * 最长公共前缀
 *
 * @Author: wangzongyu
 * @Date: 2020/3/11 20:14
 */
public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length < 1) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		String a = strs[0];
		int i;
		for (i = 0; i < a.length(); i++) {
			for (int j = 1; j < strs.length; j++) {
				String b = strs[j];
				if (b.length() < 1) {
					return "";
				}
				if (i < b.length() && a.charAt(i) != b.charAt(i)) {
					return i > 0 ? a.substring(0, i) : "";
				}
			}
		}
		return i > 0 ? a.substring(0, i) : "";
	}


	public String longestCommonPrefix1(String[] strs) {
		if (strs == null || strs.length < 1) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		String res = "";
		String a = strs[0];
		for (int i = 0; i < a.length(); i++) {
			for (int j = 1; j < strs.length; j++) {
				String b = strs[j];
				if (i >= b.length() || a.charAt(i) != b.charAt(i)){
					return res;
				}
			}
			res = res + a.charAt(i);
		}
		return res;
	}
}
