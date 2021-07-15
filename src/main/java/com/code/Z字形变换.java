package com.code;

/**
 * @Author: wangzongyu
 * @Date: 2019/7/14 14:03
 */
public class Z字形变换 {
	public String convert(String s, int numRows) {

		int len = s.length();
		if(len <= 1 || numRows == 1){
			return s;
		}
		//第一行字符间距
		int maxGap = numRows + numRows - 2;
		StringBuilder b = new StringBuilder();

		//内部行第一个字符和第二个字符的间距
		int rowGap = 2 * (numRows - 2);
		for (int row = 0; row < numRows; row++) {

			for (int index = row; index < len; index = index + maxGap) {

				b.append(s.charAt(index));
				if (needInsert(row, numRows) && (index + rowGap) < len) {
					b.append(s.charAt(index + rowGap));
				}
			}
			if(needInsert(row, numRows)) {
				rowGap  = rowGap - 2; //内部行间距在逐渐减小
			}
		}
		return b.toString();
	}

	private boolean needInsert(int row, int numRows) {
		return row > 0 && row < numRows - 1;
	}
}
