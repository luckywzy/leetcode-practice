package com.code.leetcode.editor.cn;

//你被给定一个 m × n 的二维网格 rooms ，网格中有以下三种可能的初始化值： 
//
// 
// -1 表示墙或是障碍物 
// 0 表示一扇门 
// INF 无限表示一个空的房间。然后，我们用 2³¹ - 1 = 2147483647 代表 INF。你可以认为通往门的距离总是小于 2147483647 
//的。 
// 
//
// 你要给每个空房间位上填上该房间到 最近门的距离 ，如果无法到达门，则填 INF 即可。 
//
// 
//
// 示例 1： 
//
// 
//输入：rooms = [[2147483647,-1,0,2147483647],
//              [2147483647,2147483647,2147483647,-1],
//              [2147483647,-1,2147483647,-1],
//              [0,-1,2147483647,2147483647]]
//输出：[[3,-1,0,1],
//      [2,2,1,-1],
//      [1,-1,2,-1],
//      [0,-1,3,4]]
//
// 示例 2： 
//
// 
//输入：rooms = [[-1]]
//输出：[[-1]]
// 
//
// 示例 3： 
//
// 
//输入：rooms = [[2147483647]]
//输出：[[2147483647]]
// 
//
// 示例 4： 
//
// 
//输入：rooms = [[0]]
//输出：[[0]]
// 
//
// 
//
// 提示： 
//
// 
// m == rooms.length 
// n == rooms[i].length 
// 1 <= m, n <= 250 
// rooms[i][j] 是 -1、0 或 2³¹ - 1 
// 
// Related Topics 广度优先搜索 数组 矩阵 👍 176 👎 0


import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution286 {
    /**
     * 解： g[i][j] 距离门的距离，由其周围上下左右的（房间/墙/门） 中距离门最近的，加+1决定的
     *             如果四周都是墙，则无法到达门；
     *     所以现在需要找到其四周的房间与门的距离，以此类推
     *     但是从哪里开始呢，当然是从那些是门的节点！！！
     *     所以首先找到所有是门的节点，然后从那些是门的节点，开始往四周扩散
     *     那么可以生成一个队列存储那些是门的节点，然后在遍历队列的时候，将空房间节点加入队列，（如果不是空房间，即不等于 Integer.MAX_VALUE的，说明已经遍历过了）
     * @param rooms
     */
    public void wallsAndGates(int[][] rooms) {

        LinkedList<Integer[]> queue = new LinkedList<>();
        int[][] round = new int[][]{
                {0, 1}, {0, -1},
                {1, 0}, {-1, 0}
        };

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new Integer[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            Integer[] room = queue.pop();
            int i = room[0];
            int j = room[1];

            for (int[] r : round) {
                int row = i + r[0];
                int col = j + r[1];
                if (row < 0 || row >= rooms.length || col < 0 || col >= rooms[0].length) {
                    continue;
                }
                if (rooms[row][col] != Integer.MAX_VALUE) {
                    continue;
                }
                rooms[row][col] = rooms[i][j] + 1;
                queue.add(new Integer[]{row, col});
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
