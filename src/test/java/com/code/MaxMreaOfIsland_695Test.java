package com.code;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: wangzongyu
 * @Date: 2020/4/19 10:10
 */
public class MaxMreaOfIsland_695Test {

	MaxMreaOfIsland_695 maxMreaOfIsland695 = new MaxMreaOfIsland_695();

	@Test
	public void maxAreaOfIsland1() {
		int[][] grid = {
				{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
				{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
				{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

		int maxAreaOfIsland = maxMreaOfIsland695.maxAreaOfIsland(grid);

		Assert.assertEquals(6, maxAreaOfIsland);
	}

	@Test
	public void maxAreaOfIsland2() {
		int[][] grid = {};

		int maxAreaOfIsland = maxMreaOfIsland695.maxAreaOfIsland(grid);

		Assert.assertEquals(0, maxAreaOfIsland);
	}

	@Test
	public void maxAreaOfIsland3() {
		int[][] grid = {{0,0,0,0,0,0,0,0}};

		int maxAreaOfIsland = maxMreaOfIsland695.maxAreaOfIsland(grid);

		Assert.assertEquals(0, maxAreaOfIsland);
	}
}