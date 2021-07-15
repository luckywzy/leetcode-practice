package com.code;

import java.util.LinkedList;
import java.util.List;

/**
 * 整数可以被看作是其因子的乘积。
 * <p>
 * 例如：
 * <p>
 * 8 = 2 x 2 x 2;
 * = 2 x 4.
 * 请实现一个函数，该函数接收一个整数 n 并返回该整数所有的因子组合。
 * <p>
 * 注意：
 * <p>
 * 你可以假定 n 为永远为正数。
 * 因子必须大于 1 并且小于 n。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/factor-combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution254 {
    public List<List<Integer>> getFactors(int n) {
        int start = 2;
        return doGetFactors(start, n);
    }

    /**
     * 递归处理因式分解，再汇总结果，例如
     * 12 -> 2 * 6； 6 -> 2 * 3
     * 结果集：[2,2,3],[2,6]
     * 12 -> 3 * 4;  4-> 2 * 2
     * 结果集：[3,2,2],[3,4]
     * 但是[2,2,3] 和 [3,2,2] 是重复的结果；如何避免重复计算呢
     * 之前每次计算都是从 i= 2 开始，所以会得到重复的数据，如[2,2,3] 和[3,2,2]， 那么当下次循环计算时，就从循环的i 开始计算，这样就避免了重复数据计算
     *
     * @param start
     * @param n
     * @return
     */
    private List<List<Integer>> doGetFactors(int start, int n) {
        List<List<Integer>> res = new LinkedList<>();
        for (int i = start; i < n / 2 + 1; i++) {
            List<Integer> factors = new LinkedList<>();
            int sn = n / i;
            if (i > sn) {
                break;
            }
            if (n % i == 0) {
                factors.add(sn);
                int firstFactor = i;
                List<List<Integer>> subRes = doGetFactors(i, sn);

                subRes.add(factors);
                subRes.forEach(e -> e.add(0, firstFactor));
                res.addAll(subRes);
            }
        }
        return res;
    }

    public List<List<Integer>> getFactors1(int n) {
        int start = 2;
        List<List<Integer>> res = new LinkedList<>();
        dfs(start, n, res);

        return res;
    }


    public void dfs(int start, int n, List<List<Integer>> res) {

        for (int i = start; i < n / 2 + 1; i++) {
            if( n % i == 0){

            }
        }
    }
}