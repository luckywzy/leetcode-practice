package com.code;

/**
 * 注意的地方是数字溢出的处理
 *
 * @Author: wangzongyu
 * @Date: 2019/7/20 15:19
 */
public class 整数反转 {

	public int reverse(int x) {
		int ret = 0;
		while (x != 0) {
			int pop = x % 10;
			x = x / 10;
			if (ret > Integer.MAX_VALUE / 10 || ret == Integer.MAX_VALUE / 10 && pop > 7) return 0;
			if (ret < Integer.MIN_VALUE / 10 || ret == Integer.MIN_VALUE / 10 && pop < -8) return 0;
			ret = ret * 10 + pop;
		}

		return ret;
	}
}
