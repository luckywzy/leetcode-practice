package com.code;

/**
 * @Author: wangzongyu
 * @Date: 2019/7/20 15:48
 */
public class 字符串转换为数字 {
	public int myAtoi(String str) {
		String trimed = str.trim();
		int size = trimed.length();
		if (size < 1) return 0;
		char[] chars = new char[size];
		trimed.getChars(0, size, chars, 0);
		int index = 0;
		int ret = 0;
		int sign = +1;
		if (chars[index] == '-') {
			sign = -1;
			index++;
		} else if (chars[index] == '+') {
			index++;
		}

		while (index < size) {
			char tmp = chars[index];
			//尽可能多的连续数字， 之后多余的字符将其忽略
			if ('0' <= tmp && tmp <= '9') {
				if (ret > Integer.MAX_VALUE / 10 || ret == Integer.MAX_VALUE / 10 && (tmp - '0') > 7){
					return  sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
				}
				ret = ret * 10 + (tmp - '0');
			} else {
				break;
			}
			index++;
		}
		return ret * sign;
	}

	/*public int myAtoi2(String str) {
		String trimed = str.trim();
		boolean matches = trimed.matches("^[+|-|0-9][0-9] ?");
		int sign = 0;
		if(trimed.startsWith("-")){
			sign
		}
	}*/
}
