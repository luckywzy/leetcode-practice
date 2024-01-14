package com.code.leetcode.editor.cn.leetcode.editor.cn;//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics 数组 排序 👍 2194 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        // [[1,3],[2,6],[8,10],[15,18]]

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(List.of(intervals[0][0], intervals[0][1]));

        for (int i = 1; i < intervals.length; i++) {
            List<Integer> last = result.get(result.size() - 1);
            if (intervals[i][0] <= last.get(1)) {
                result.remove(result.size() - 1);
                result.add(List.of(last.get(0), Math.max(last.get(1), intervals[i][1])));
            } else {
                result.add(List.of(intervals[i][0], intervals[i][1]));
            }
        }
        int[][] array = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            List<Integer> list = result.get(i);
            array[i][0] = list.get(0);
            array[i][1] = list.get(1);
        }
        return array;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
