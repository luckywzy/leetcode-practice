package com.code.leetcode.editor.cn.leetcode.editor.cn;//给你一个非负整数数组 nums 和一个整数 target 。
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
//
// Related Topics 数组 动态规划 回溯 👍 1823 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution494 {
    /**
     *  加法总和为X，减法对应的总和为sum - X
     *  X - (sum - X) = target
     *  X = (target + sum) / 2
     *  考虑整数溢出，除法向下取整
     *
     *  1.dp[i][j] 表示从num[0..i]中任取，满足j这么大的容量的方式有多少种
     *  2.dp[i][j]  = dp[i-1][j-num[i]] + dp[i-1][j] or num[i] > j   dp[i-1][j]
     *  3.dp[0[j] = ? num[i] <= j 时， dp[0][j] = 1
     *  4.i-> 1..nums.length,  j -> 1...nums[i]
     *
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int bagSize = (target + sum) / 2;

        int[][] dp = new int[nums.length][bagSize +1];
        if (nums[0] <= bagSize){
            dp[0][nums[0]] = 1;
        }
        int zeroNum = 0 ;
        for (int i=0; i <nums.length; i++){
            if (nums[i] == 0){
                zeroNum ++;
            }
            dp[i][0] = (int) Math.pow(2, zeroNum);
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (nums[i] > j){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j-nums[i]] + dp[i-1][j];
                }
            }
        }

        return dp[nums.length-1][bagSize];
    }


    public int findTargetSumWays_backTrace(int[] nums, int target) {
        Arrays.sort(nums);
        dfs(nums, target, 0, 0, new ArrayList<>());
        return result;
    }

    int result = 0;

    void dfs(int[] nums, int target, int startIndex, int currentSum, List<Integer> path) {

        if (target == currentSum && path.size() == nums.length) {
            ArrayList<Integer> list = new ArrayList<>(path);
            list.forEach(p -> System.out.print(p + ","));
            System.out.println();
            result++;
        }

        for (int i = startIndex; i < nums.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    path.add(nums[i]);
                    dfs(nums, target, i + 1, currentSum + nums[i], path);
                    path.remove(path.size() - 1);
                } else {
                    path.add(-nums[i]);
                    dfs(nums, target, i + 1, currentSum - nums[i], path);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
