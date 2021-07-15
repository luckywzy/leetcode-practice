package com.code;

/**
 * @Author: wangzongyu
 * @Date: 2019/7/21 13:32
 */
public class 正则表达式匹配 {

	public boolean isMatch(String s, String p) {
		if(p.isEmpty()) return s.isEmpty();
		boolean leftMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

		if(p.length() >= 2 && p.charAt(1) == '*'){
			return isMatch(s, p.substring(2)) ||
					(leftMatch && isMatch(s.substring(1), p));
		}else {
			return leftMatch && isMatch(s.substring(1), p.substring(1));
		}
	}



	public boolean isMatch1(String s, String p) {
		if (s.length() < 1) {
			return true;
		}
		if (p.length() < 1) {
			return false;
		}
		char[] sources = s.toCharArray();
		char[] pattern = p.toCharArray();
		int index = 0;
		int pOff = 0;
		int pLen = pattern.length;
		int sLen = sources.length;
		while (index < sLen && pOff < pLen) {
			if (pattern[pOff] == '.') {
				pOff++;
				index++;
			} else if (pattern[pOff] == '*') {
				//1。 .* 匹配0 个或多个任意字符
				if (pattern[pOff - 1] == '.') {
					index++;
				} else {
					// 匹配一个 ，源字符串移动，pattern 不动
					if (rexAsterisk(pattern[pOff - 1], sources[index])) {
						index++;
					} else { //匹配 0 个，源字符串不动，pattern +1
						pOff++;
					}
				}
				//字符 匹配 源字符串 和 pattern 都移动
			} else if (pattern[pOff] == sources[index]) {
				pOff++;
				index++;
			} else {//本次什么都没有匹配到，只把 pattern 移动 看看后面还有没有机会匹配
				pOff++;
			}
		}
		if (pOff < pLen) {
			if (pLen - pOff > 2) {
				return false;
			} else if (pLen - pOff == 2) {
				return pattern[pOff + 1] == '*' || pattern[pOff + 1] == sources[index-1];
			} else {
				return pOff == pLen - 1 && pattern[pOff] == '*';
			}

		}

		return index >= sLen;
	}

	/**
	 * '*' 匹配零个或多个前面的那一个元素
	 */
	public boolean rexAsterisk(char pre, Character cur) {
		if (cur == null) {
			return true;
		}
		return pre == cur;
	}
}
