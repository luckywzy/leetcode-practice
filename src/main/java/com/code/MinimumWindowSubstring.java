package com.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口法
 *
 * @Author: wangzongyu
 * @Date: 2020/4/18 20:22
 */
public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		int l = 0;
		int h = 0;
		Map<Character, Integer> charToCntMap = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			if (charToCntMap.containsKey(t.charAt(i))) {
				charToCntMap.put(t.charAt(i), charToCntMap.get(t.charAt(i)) + 1);
			} else {
				charToCntMap.put(t.charAt(i), 1);
			}
		}

		int findChar = 0;
		int minLen = s.length() + 1;
		int minIndex = 0;
		while (h < s.length()) {
			char c = s.charAt(h);
			if (charToCntMap.containsKey(c)) {
				//这里是一直减，相同字符个数会被减成负的
				charToCntMap.put(c, charToCntMap.get(c) - 1);
				if (charToCntMap.get(c) >= 0) {
					findChar++;
				}

				while (findChar == t.length()) {
					if (h - l + 1 < minLen) {
						minIndex = l;
						minLen = h - l + 1;
					}
					char lc = s.charAt(l);
					if (charToCntMap.containsKey(lc)) {
						charToCntMap.put(lc, charToCntMap.get(lc) + 1);
						//直到大于 0 的时候，才认为这个字符未被覆盖到
						if(charToCntMap.get(lc) > 0){
							findChar--;
						}
					}
					l++;
				}
			}
			h++;

		}

		return minLen > s.length() ? "" : s.substring(minIndex, minIndex + minLen);
	}
}
