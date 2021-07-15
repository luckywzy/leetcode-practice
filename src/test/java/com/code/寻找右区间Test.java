package com.code;

import org.junit.Test;

/**
 * @Author: wangzongyu
 * @Date: 2019/3/30 17:38
 */
public class 寻找右区间Test {

	@Test
	public void findRightInterval() {
		寻找右区间 a = new 寻找右区间();
		Interval t1 = new Interval(1, 2);
		Interval t2 = new Interval(2, 3);
		Interval t3 = new Interval(0, 1);
		Interval t4 = new Interval(3, 4);
		Interval[] intervals = new Interval[4];
		intervals[0] = t1;
		intervals[1] = t2;
		intervals[2] = t3;
		intervals[3] = t4;
		int[] rightInterval = a.findRightInterval1(intervals);

		for (int i : rightInterval) {
			System.out.println(i+"\t");
		}
	}
	@Test
	public void findRightInterval1() {
		寻找右区间 a = new 寻找右区间();
		Interval t1 = new Interval(3, 4);
		Interval t2 = new Interval(2, 3);
		Interval t3 = new Interval(1, 2);
		Interval[] intervals = new Interval[3];
		intervals[0] = t1;
		intervals[1] = t2;
		intervals[2] = t3;
		int[] rightInterval = a.findRightInterval1(intervals);

		for (int i : rightInterval) {
			System.out.println(i+"\t");
		}
	}@Test
	public void findRightInterval2() {
		寻找右区间 a = new 寻找右区间();
		Interval t1 = new Interval(1, 2);
		Interval t2 = new Interval(2, 3);
		Interval t3 = new Interval(0, 1);
		Interval t4 = new Interval(3, 4);
		Interval[] intervals = new Interval[4];
		intervals[0] = t1;
		intervals[1] = t2;
		intervals[2] = t3;
		intervals[3] = t4;
		int[] rightInterval = a.findRightInterval2(intervals);

		for (int i : rightInterval) {
			System.out.println(i+"\t");
		}
	}
	@Test
	public void findRightInterval3() {
		寻找右区间 a = new 寻找右区间();
		Interval t1 = new Interval(3, 4);
		Interval t2 = new Interval(2, 3);
		Interval t3 = new Interval(1, 2);
		Interval[] intervals = new Interval[3];
		intervals[0] = t1;
		intervals[1] = t2;
		intervals[2] = t3;
		int[] rightInterval = a.findRightInterval2(intervals);

		for (int i : rightInterval) {
			System.out.println(i+"\t");
		}
	}
}