package com.code.leetcode.editor.cn.leetcode.editor.cn;//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2772 👎 0


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<>();
        Set<Integer> used = new HashSet<>();
        dfs(nums, used, path, result);
        return result;
    }


    void dfs(int[] nums, Set<Integer> used, List<Integer> path, List<List<Integer>> result){
        if (path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return ;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used.contains(nums[i])){
                continue;
            }
            used.add(nums[i]);
            path.add(nums[i]);
            dfs(nums,  used, path, result);
            path.remove(path.size() - 1);
            used.remove(nums[i]);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
