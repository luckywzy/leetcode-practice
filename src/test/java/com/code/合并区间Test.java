package com.code;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: wangzongyu
 * @Date: 2019/8/18 16:02
 */
public class 合并区间Test {

	合并区间 s= new 合并区间();

	@Test
	public void merge() {
		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		int[][] result = {{1,6},{8,10},{15,18}};
		int[][] merge = s.merge(intervals);
		Assert.assertEquals(result, merge);
	}

	@Test
	public void merge2() {
		int[][] intervals = {{1,3},{3,6}};
		int[][] result = {{1,6}};
		int[][] merge = s.merge(intervals);
		Assert.assertEquals(result, merge);
	}

	@Test
	public void merge2_1() {
		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		int[][] result = {{1,6},{8,10},{15,18}};
		int[][] merge = s.merge1(intervals);
		Assert.assertEquals(result, merge);
	}

	@Test
	public void merge2_2() {
		int[][] intervals = {{1,3},{3,6}};
		int[][] result = {{1,6}};
		int[][] merge = s.merge1(intervals);
		Assert.assertEquals(result, merge);
	}
}