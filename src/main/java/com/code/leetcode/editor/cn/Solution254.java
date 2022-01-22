package com.code.leetcode.editor.cn;

//整数可以被看作是其因子的乘积。 
//
// 例如： 
//
// 8 = 2 x 2 x 2;
//  = 2 x 4. 
//
// 请实现一个函数，该函数接收一个整数 n 并返回该整数所有的因子组合。 
//
// 注意： 
//
// 
// 你可以假定 n 为永远为正数。 
// 因子必须大于 1 并且小于 n。 
// 
//
// 示例 1： 
//
// 输入: 1
//输出: []
// 
//
// 示例 2： 
//
// 输入: 37
//输出: [] 
//
// 示例 3： 
//
// 输入: 12
//输出:
//[
//  [2, 6],
//  [2, 2, 3],
//  [3, 4]
//] 
//
// 示例 4: 
//
// 输入: 32
//输出:
//[
//  [2, 16],
//  [2, 2, 8],
//  [2, 2, 2, 4],
//  [2, 2, 2, 2, 2],
//  [2, 4, 4],
//  [4, 8]
//]
// 
// Related Topics 数组 回溯 👍 104 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution254 {
    public List<List<Integer>> getFactors(int n) {
        return doGetFactors(2, n);
    }

    public List<List<Integer>> doGetFactors(int start, int n) {
        List<List<Integer>> factorList = new ArrayList<>();

        for (int i = start; i < n / 2 + 1; i++) {
            if (i > n / i) {
                break;
            }
            if (n % i == 0) {
                int f1 = i;
                ArrayList<Integer> list = new ArrayList<>();
                list.add(n / i);
                List<List<Integer>> factors = doGetFactors(i, n / i);
                factors.add(list);
                factors.forEach(f -> f.add(0, f1));
                factorList.addAll(factors);
            }
        }
        return factorList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
