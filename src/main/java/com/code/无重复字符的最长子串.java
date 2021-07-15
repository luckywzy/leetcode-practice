package com.code;

import java.util.*;

/**
 * @Author: wangzongyu
 * @Date: 2019/4/17 19:20
 */
public class 无重复字符的最长子串 {

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.equals("")) {
			return 0;
		}
		char[] str = s.toCharArray();
		//存放已使用的字符，和下标
		Set<Character> usedChar = new HashSet<>();
		//当前无重复字符序列
		Deque<Character> queue = new ArrayDeque<>();
		int longest = 0;

		for (int i = 0; i < str.length; i++) {
			//遇见重复字符时
			if (usedChar.contains(str[i])) {
				//计算当前最长无重复字符串的长度
				if (longest < queue.size()) {
					longest = queue.size();
				}
				char tmp = queue.getLast();
				//从队尾开始删除字符，直到重复字符（包含删除重复字符）
				while (!queue.isEmpty()) {
					if (queue.getLast() != str[i]) {
						usedChar.remove(queue.removeLast());
					}else if (queue.getLast() == str[i]) {
						usedChar.remove(queue.removeLast());
						break;
					}
				}
				queue.addFirst(str[i]);
				usedChar.add(str[i]);
			} else { // 未遇见重复字符时,入队列,入 set
				queue.addFirst(str[i]);
				usedChar.add(str[i]);
				if(longest < queue.size()) {
					longest = queue.size();
				}
			}
		}
		return longest;
	}
}
