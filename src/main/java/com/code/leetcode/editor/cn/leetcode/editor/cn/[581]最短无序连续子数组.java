package com.code.leetcode.editor.cn.leetcode.editor.cn;
//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
//
// Related Topics 栈 贪心 数组 双指针 排序 单调栈 👍 1128 👎 0


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution581 {

    /**
     * [2,6,4,8,10,9,15]
     * <p>
     * [6, 4, 8, 10, 9]
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        //2,6,4,8,10,9,15
        //中段满足最小值大于 左段 的最大值，最大值小于右段的最小值。
        //2《 4， 10 《 15
        int len = nums.length;
        int min = nums[len - 1];
        int max = nums[0];
        int begin = 0;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < max) {
                end = i;
            } else {
                max = nums[i];
            }
            if (nums[len - i - 1] > min) {
                begin = len - i - 1;
            } else {
                min = nums[len - i - 1];
            }
        }
        return end - begin + 1;
    }

    public static void main(String[] args) {
        //  System.out.println(new Solution581().macth("aeeeebcdefabdc", "abc"));
        System.out.println(new Solution581().macth1("aeeeebcdefabdc", "abc"));
        System.out.println(new Solution581().macth1("afabaadc", "aaa"));
        System.out.println(new Solution581().macth1("adabbca", "acb"));
    }

    String macth(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int l = 0;
        int k = 0;
        int r = 0;
        String res = s;
        int[] next = new int[tt.length];

        for (l = 0; l < s.length(); l++) {
            for (r = l; r < s.length(); r++) {
                if (ss[r] == tt[k]) {
                    next[k] = r;
                    k++;
                }
                if (k == tt.length) {
                    String ans = s.substring(next[0], next[tt.length - 1] + 1);
                    if (ans.length() < res.length()) {
                        res = ans;
                    }
                    k = 0;
                    break;
                }
            }
        }
        return res;
    }

    String macth1(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int k = 0;
        String res = s;
        int[] next = new int[tt.length];

        int l = 0, r = 0;
        while (l < s.length()) {
            r = l;
            k = 0;
            while (r < s.length()) {
                if (ss[r] == tt[k]) {
                    next[k] = r;
                    k++;
                }
                if (k == tt.length) {
                    String ans = s.substring(next[0], next[tt.length - 1] + 1);
                    if (ans.length() < res.length()) {
                        res = ans;
                    }
                    break;
                }
                r++;
            }
            l++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
