package com.code;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: wangzongyu
 * @Date: 2019/8/25 14:21
 */
public class SortColorsTest {

	SortColors sortColors = new SortColors();

	@Test
	public void sortColors1() {
		int[] in={2,0,2,1,1,0};
		int[] out={0,0,1,1,2,2};
		sortColors.sortColors1(in);
		assertArrayEquals(out, in);
	}

	@Test
	public void sortColors2() {
		int[] in={0,0,1,1,0};
		int[] out={0,0,0,1,1};
		sortColors.sortColors1(in);
		assertArrayEquals(out, in);
	}

	@Test
	public void sortColors3() {
		int[] in={};
		int[] out={};
		sortColors.sortColors1(in);
		assertArrayEquals(out, in);
	}

	@Test
	public void sortColors2_1() {
		int[] in={2,0,2,1,1,0};
		int[] out={0,0,1,1,2,2};
		sortColors.sortColors2(in);
		assertArrayEquals(out, in);
	}

	@Test
	public void sortColors2_2() {
		int[] in={0,0,1,1,0};
		int[] out={0,0,0,1,1};
		sortColors.sortColors2(in);
		assertArrayEquals(out, in);
	}

	@Test
	public void sortColors2_3() {
		int[] in={};
		int[] out={};
		sortColors.sortColors2(in);
		assertArrayEquals(out, in);
	}

	@Test
	public void sortColors3_1() {
		int[] in={2,0,2,1,1,0};
		int[] out={0,0,1,1,2,2};
		sortColors.sortColors3(in);
		assertArrayEquals(out, in);
	}

	@Test
	public void sortColors3_2() {
		int[] in={0,0,1,1,0};
		int[] out={0,0,0,1,1};
		sortColors.sortColors3(in);
		assertArrayEquals(out, in);
	}

	@Test
	public void sortColors3_3() {
		int[] in={4,5,6,1,2,3};
		int[] out={1,2,3,4,5,6};
		sortColors.sortColors3(in);
		assertArrayEquals(out, in);
	}
}