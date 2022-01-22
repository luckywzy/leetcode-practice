package com.code;

/**
 * @Author: wangzongyu
 * @Date: 2019/3/24 16:13
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        boolean canJump = solution1.canJump(new int[]{3,2,1,0,4});
        System.out.println(canJump);
    }

    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        //[3,2,1,0,4]
        for (int i = 1, numsLength = nums.length; i < numsLength; i++) {
            //能跳到当前位置
            if (dp[i - 1] >= i) {
                dp[i] = Math.max(i + nums[i], dp[i - 1]);
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[lastPos] >= lastPos;
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int h = m + n - 1;
        int i1 = m - 1, i2 = n - 1;
        while (h >= 0 && i1 >= 0 && i2 >= 0) {
            if (nums1[i1] > nums2[i2]) {
                nums1[h] = nums1[i1];
                i1--;
            } else {
                nums1[h] = nums2[i2];
                i2--;
            }
            h--;
        }
        int p = i1 > -1 ? i1 : i2;
        int[] pn = i1 > -1 ? nums1 : nums2;
        while (h >= 0 && p >= 0) {
            nums1[h--] = pn[p--];
        }
    }


    public int[] plusOne(int[] digits) {
        int jw = 0;

        int h = digits.length - 1;
        digits[h] = digits[h] + 1;
        while (h >= 0) {
            int k = digits[h] + jw;
            jw = k / 10;
            digits[h] = (k > 9 ? k - 10 : k);
            h--;
        }
        if (jw > 0) {
            int[] res = new int[digits.length + 1];
            System.arraycopy(digits, 0, res, 1, digits.length);
            res[0] = jw;
            return res;
        } else {
            return digits;
        }
    }

}
