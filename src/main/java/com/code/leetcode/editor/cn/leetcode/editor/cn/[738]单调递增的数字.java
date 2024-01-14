package com.code.leetcode.editor.cn.leetcode.editor.cn;//当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
//
// 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 10
//输出: 9
// 
//
// 示例 2: 
//
// 
//输入: n = 1234
//输出: 1234
// 
//
// 示例 3: 
//
// 
//输入: n = 332
//输出: 299
// 
//
// 
//
// 提示: 
//
// 
// 0 <= n <= 10⁹ 
// 
//
// Related Topics 贪心 数学 👍 438 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution738 {
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        int[] num = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            num[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }

        int flag = num.length;
        for (int i = num.length - 1; i > 0; i--) {
            if (num[i] < num[i - 1]) {
                flag = i;
                num[i - 1]--;
            }
        }
        for (int i = flag; i < num.length; i++) {
            num[i] = 9;
        }
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum += num[i] * Math.pow(10, num.length - 1 - i);
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
