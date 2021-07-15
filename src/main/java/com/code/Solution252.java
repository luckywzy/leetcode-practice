package com.code;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/meeting-rooms/
 * 给定一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，
 * 请你判断一个人是否能够参加这里面的全部会议。
 * 输入：intervals = [[0,30],[5,10],[15,20]]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：intervals = [[7,10],[2,4]]
 * 输出：true
 * 0 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti < endi <= 10^6
 */
class Solution252 {
    public boolean canAttendMeetings(int[][] intervals) {
        List<Pair> pairs = Arrays.stream(intervals)
                .map(e -> new Pair(e[0], e[1]))
                .sorted(Comparator.comparingInt(o -> o.l))
                .collect(Collectors.toList());

        Pair prev = null;
        Pair cur = null;
        for (Pair pair : pairs) {
            prev = cur;
            cur = pair;
            if (prev != null && cur != null) {
                if (prev.r > cur.l) {
                    return false;
                }
            }
        }
        return true;
    }

    static class Pair {
        int l;
        int r;

        public Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }


}