package com.code.leetcode.editor.cn;

//给出一个二进制数组 data，你需要通过交换位置，将数组中 任何位置 上的 1 组合到一起，并返回所有可能中所需 最少的交换次数。 
//
// 
//
// 示例 1: 
//
// 
//输入: data = [1,0,1,0,1]
//输出: 1
//解释: 
//有三种可能的方法可以把所有的 1 组合在一起：
//[1,1,1,0,0]，交换 1 次；
//[0,1,1,1,0]，交换 2 次；
//[0,0,1,1,1]，交换 1 次。
//所以最少的交换次数为 1。
// 
//
// 示例 2: 
//
// 
//输入：data = [0,0,0,1,0]
//输出：0
//解释： 
//由于数组中只有一个 1，所以不需要交换。 
//
// 示例 3: 
//
// 
//输入：data = [1,0,1,0,1,0,0,1,1,0,1]
//输出：3
//解释：
//交换 3 次，一种可行的只用 3 次交换的解决方案是 [0,0,0,0,0,1,1,1,1,1,1]。
// 
//
// 示例 4: 
//
// 
//输入: data = [1,0,1,0,1,0,1,1,1,0,1,0,0,1,1,1,0,0,1,1,1,0,1,0,1,1,0,0,0,1,1,1,1,
//0,0,1]
//输出: 8
// 
//
// 
//
// 提示: 
//
// 
// 1 <= data.length <= 10⁵ 
// data[i] == 0 or 1. 
// 
// Related Topics 数组 滑动窗口 👍 59 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution1151 {

    /**
     * 解法2
     * 得到每个长度下 1 的数量 sum[i] 表示 到i为止 1的数量；计算1的总数量totalOne；
     * 计算sum 中每个窗口下所需要的0 的数量 ， min(totalOne  - (sum[k] - sum[k-totalOne]);
     * @param data
     * @return
     */
    public int minSwaps(int[] data) {
        int[] sum = new int[data.length + 1];
        for (int i = 0; i < data.length; i++) {
            sum[i + 1] = sum[i] + data[i];
        }
        int totalOne = sum[data.length];
        int res = totalOne;
        for (int i = totalOne; i < sum.length; i++) {
            res = Math.min(res, totalOne - (sum[i] - sum[i - totalOne]));
        }
        return res;
    }


    /**
     * 解法1
     * 得到1的数量oneCnt
     * 构建oneCnt大小的滑动窗口，此窗口内的1的数量为cur
     * 窗口向右滑动，假如遍历到i, 计算当前窗口的1的数量，cur + = data[i] - data[i-oneCnt]；
     * 取得cur最大的值 maxCur，即某个窗口下1数量最多，那么只需要最少的0 交换，所以结果为 oneCnt - maxCur;
     * @param data
     * @return
     */
    public int minSwaps2(int[] data) {
        int oneCnt = 0;
        for (int i = 0, dataLength = data.length; i < dataLength; i++) {
            if (data[i] == 1) {
                oneCnt++;
            }
        }
        int cur = 0;
        for (int i = 0; i < oneCnt; i++) {
            if(data[i] == 1){
                cur++;
            }
        }
        int maxOne = cur;
        for (int i=oneCnt; i<data.length; i++){
            cur += data[i] - data[i - oneCnt];
            maxOne = Math.max(maxOne, cur);
        }
        return oneCnt-maxOne;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
