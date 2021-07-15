package com.code;

/**
 * @Author: wangzongyu
 * @Date: 2020/4/19 10:04
 */
public class MaxMreaOfIsland_695 {


	public int maxAreaOfIsland(int[][] grid) {

		if (grid.length <= 0 || grid[0].length <= 0) {
			return 0;
		}
		int maxArea = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				maxArea = Math.max(maxArea, dfs(grid, i, j));
			}
		}
		return maxArea;

	}

	private int dfs(int[][] grid, int i, int j) {
		if (i < 0) {
			return 0;
		}
		if (i >= grid.length) {
			return 0;
		}
		if (j < 0) {
			return 0;
		}
		if (j >= grid[0].length) {
			return 0;
		}
		if (grid[i][j] == 0) {
			return 0;
		}
		//标记已访问
		grid[i][j] = 0;

		return 1 + dfs(grid, i, j + 1) +
				dfs(grid, i + 1, j) +
				dfs(grid, i - 1, j) +
				dfs(grid, i, j - 1);
	}

}
