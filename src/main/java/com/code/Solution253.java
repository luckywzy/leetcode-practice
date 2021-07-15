package com.code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，
 * 为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
 * <p>
 * 输入：intervals = [[0,30],[5,10],[15,20]]
 * 输出：2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/meeting-rooms-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution253 {

    /**
     * 解法1：通过left 的排序后，合并 不重叠的区间，剩下的区间个数就是需要的room 个数
     * 理解成上下车问题会比较容易解决，不用在意是谁上车还是下车，只需要注意什么时候上下车就可以。
     *
     * @param intervals
     * @return
     */
    public int minMeetingRooms(int[][] intervals) {
        List<Pair> pairs = Arrays.stream(intervals)
                .map(e -> new Pair(e[0], e[1]))
                .sorted(Comparator.comparingInt(o -> o.l))
                .collect(Collectors.toList());

        LinkedList<Pair> mergePair = new LinkedList<>();
        for (Pair cur : pairs) {
            if (mergePair.isEmpty()) {
                mergePair.add(cur);
            } else {
                boolean has = false;
                for (Pair pair : mergePair) {
                    if (pair.r <= cur.l) {
                        //没有重叠则合并
                        pair.r = cur.r;
                        has = true;
                        break;
                    }
                }
                if (!has) {
                    mergePair.add(cur);
                }
            }
        }
        return mergePair.size();

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