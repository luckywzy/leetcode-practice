package com.code;

import java.util.*;

/**
 * @Author: wangzongyu
 * @Date: 2019/8/18 15:30
 */
public class 合并区间 {


	/**
	 * 重叠的区间需要合并这是关键的地方！！
	 * 首先 将所有区间按照起始位置left进行排序；创建一个空的结果集
	 * 接着，遍历 排好序的区间集合
	 * 1. 如果当前区间的起始位置大于 结果集中最后一个区间的结束位置right，说明没有重叠，应该把新的区间插入结果集
	 * 2. 否则，说明有区间重叠，取当前区间的结束位置和结果集最后一个元素的结束位置的较大值
	 *
	 * 为什么这么做是可行的？
	 * 首先我们对intervals数组 的起始位置left进行排序了
	 * 如果没有重叠 那么 结果集的每一个区间连接起来一定是有序的；
	 * 有重叠也只会在当前结果集的最后一个区间部分有重叠，所以只需要修改最后一个区间的 right 即可
	 *
	 * @param intervals
	 * @return
	 */
	public int[][] merge(int[][] intervals) {
		ArrayList<Pair> list = new ArrayList<>(intervals.length);
		for (int[] interval : intervals) {
			list.add(new Pair(interval[0], interval[1]));
		}
		switch ()

		list.sort(Comparator.comparingInt(o -> o.left));

		LinkedList<Pair> pairs = new LinkedList<>();
		for (Pair pair : list) {

			if(pairs.isEmpty() || pairs.getLast().right < pair.left){
				pairs.add(pair);
			}else {
				pairs.getLast().right = Math.max(pair.right, pairs.getLast().right);
			}
		}

		int[][] result = new int[pairs.size()][2];
		int k=0;
		for (Pair pair : pairs) {
			result[k][0] = pair.left;
			result[k][1] = pair.right;
			k ++;
		}

		return result;
	}

	public int[][] merge1(int[][] intervals) {
		ArrayList<Pair> list = new ArrayList<>(intervals.length);
		for (int[] interval : intervals) {
			list.add(new Pair(interval[0], interval[1]));
		}

		list.sort(Comparator.comparingInt(o -> o.left));

		int[][] result = new int[intervals.length][2];
		int k=-1;
		for (Pair pair : list) {
			if(k < 0  || result[k][1] < pair.left){
				k++;
				result[k][0] = pair.left;
				result[k][1] = pair.right;

			}else {
				result[k][1] = pair.right > result[k][1] ? pair.right : result[k][1];
			}
		}
		return Arrays.copyOf(result,k+1);
	}



	public static class Pair{
		int left;
		int right;

		public Pair(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}
}
