package com.code;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: wangzongyu
 * @Date: 2019/3/24 16:13
 */
public class 寻找右区间 {

	public static void main(String[] args) {

	}

	public int[] findRightInterval1(Interval[] intervals) {

		int[] res = new int[intervals.length];
		int end[] = new int[intervals.length];

		for (int i = 0; i < res.length; i++) {
			res[i] = -1;
			end[i] = -1;
		}
		//记录成功的右区间的 start

		for (int i = 0; i < intervals.length; i++) {
			for (int j = 0; j < intervals.length; j++) {
				if (i == j) continue;

				Interval left = intervals[i];
				Interval right = intervals[j];

				//左边的 end 小于 右边的 start
				if (left.end <= right.start) {
					//如果是第一次进来
					if (res[i] == -1) {
						res[i] = j;
						end[i] = right.start;
					}
					//再次进来,只有当 这次的 right.start 小于之前的设置的
					if (end[i] > right.start) {
						res[i] = j;
						end[i] = right.start;
					}
				}
			}
		}

		return res;
	}

	public int[] findRightInterval2(Interval[] intervals) {
		int length = intervals.length;
		int res[] = new int[length];
		//start,index
		Map<Integer, Integer> startAndIndexMap = new HashMap<>();
		int index = 0;
		for (Interval interval : intervals) {
			startAndIndexMap.put(interval.start, index);
			index++;
		}
		List<Integer> sortedStart = startAndIndexMap.keySet().stream().sorted().collect(Collectors.toList());
		for (int i = 0; i < length; i++) {
			int key = intervals[i].end;
			int offset = mybinarySearch(sortedStart, key);
			if(offset < length){
				res[i] = startAndIndexMap.get(sortedStart.get(offset));
			}else {
				res[i] = -1;
			}
		}
		return res;
	}

	private int mybinarySearch(List<Integer> sortedStart, int key) {
		int low = 0;
		int mid = -1 ;
		int high = sortedStart.size() -1 ;
		while (low <= high) {
			mid = (low + high) / 2;
			int val = sortedStart.get(mid);
			if (val < key) {
				low = mid + 1;
			}else {
				high = mid - 1;
			}
		}
		return low;
	}
}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}