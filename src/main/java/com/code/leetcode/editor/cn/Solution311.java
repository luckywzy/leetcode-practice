package com.code.leetcode.editor.cn;

//给你两个 稀疏矩阵 A 和 B，请你返回 AB 的结果。你可以默认 A 的列数等于 B 的行数。 
//
// 请仔细阅读下面的示例。 
//
// 
//
// 示例： 
//
// 输入：
//
//A = [
//  [ 1, 0, 0],
//  [-1, 0, 3]
//]
//
//B = [
//  [ 7, 0, 0 ],
//  [ 0, 0, 0 ],
//  [ 0, 0, 1 ]
//]
//
//输出：
//
//     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
//AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
//                  | 0 0 1 |
// 
// Related Topics 数组 哈希表 矩阵 👍 60 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution311 {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int[][] res = new int[mat1.length][mat1[0].length];
        int i = 0;
        for (int[] row1 : mat1) {
            cal(row1, mat2, res, i);
            i++;
        }

        return res;
    }

    private void cal(int[] row1, int[][] mat2, int[][] res, int index) {
        for (int i=0; i<mat2[0].length; i++) {
            int t = 0;
            for (int j = 0; j < mat2.length; j++) {
                t += row1[i] * mat2[j][i];
            }
            res[index][i] = t;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
