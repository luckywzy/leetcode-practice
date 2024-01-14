package com.code.leetcode.editor.cn.leetcode.editor.cn;
//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1578 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int startRow = 0;
        int startCol = 0;
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;

        while (startRow <= row && startCol <= col) {
            List<Integer> list = sim(matrix, startRow, row, startCol, col);
            result.addAll(list);
            startRow++;
            row--;
            startCol++;
            col--;
        }
        return result;
    }

    public List<Integer> sim(int[][] matrix, int startRow, int row, int startCol, int col) {
        List<Integer> result = new ArrayList<Integer>();

        for (int i = startRow; i <= col; i++) {
            result.add(matrix[startRow][i]);
        }

        for (int j = startCol+1; j <= row; j++) {
            result.add(matrix[j][col]);
        }
        for (int i = col-1; i > startRow; i--) {
            result.add(matrix[row][i]);
        }

        for (int i = row; i > startCol; i--) {
            result.add(matrix[i][startCol]);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
