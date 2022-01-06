package com.code.leetcode.editor.cn;

//请在 n × n 的棋盘上，实现一个判定井字棋（Tic-Tac-Toe）胜负的神器，判断每一次玩家落子后，是否有胜出的玩家。 
//
// 在这个井字棋游戏中，会有 2 名玩家，他们将轮流在棋盘上放置自己的棋子。 
//
// 在实现这个判定器的过程中，你可以假设以下这些规则一定成立： 
//
// 1. 每一步棋都是在棋盘内的，并且只能被放置在一个空的格子里； 
//
// 2. 一旦游戏中有一名玩家胜出的话，游戏将不能再继续； 
//
// 3. 一个玩家如果在同一行、同一列或者同一斜对角线上都放置了自己的棋子，那么他便获得胜利。 
//
// 示例: 
//
// 给定棋盘边长 n = 3, 玩家 1 的棋子符号是 "X"，玩家 2 的棋子符号是 "O"。
//
//TicTacToe toe = new TicTacToe(3);
//
//toe.move(0, 0, 1); -> 函数返回 0 (此时，暂时没有玩家赢得这场对决)
//|X| | |
//| | | |    // 玩家 1 在 (0, 0) 落子。
//| | | |
//
//toe.move(0, 2, 2); -> 函数返回 0 (暂时没有玩家赢得本场比赛)
//|X| |O|
//| | | |    // 玩家 2 在 (0, 2) 落子。
//| | | |
//
//toe.move(2, 2, 1); -> 函数返回 0 (暂时没有玩家赢得比赛)
//|X| |O|
//| | | |    // 玩家 1 在 (2, 2) 落子。
//| | |X|
//
//toe.move(1, 1, 2); -> 函数返回 0 (暂没有玩家赢得比赛)
//|X| |O|
//| |O| |    // 玩家 2 在 (1, 1) 落子。
//| | |X|
//
//toe.move(2, 0, 1); -> 函数返回 0 (暂无玩家赢得比赛)
//|X| |O|
//| |O| |    // 玩家 1 在 (2, 0) 落子。
//|X| |X|
//
//toe.move(1, 0, 2); -> 函数返回 0 (没有玩家赢得比赛)
//|X| |O|
//|O|O| |    // 玩家 2 在 (1, 0) 落子.
//|X| |X|
//
//toe.move(2, 1, 1); -> 函数返回 1 (此时，玩家 1 赢得了该场比赛)
//|X| |O|
//|O|O| |    // 玩家 1 在 (2, 1) 落子。
//|X|X|X|
// 
//
// 
//
// 进阶: 
//您有没有可能将每一步的 move() 操作优化到比 O(n²) 更快吗? 
// Related Topics 设计 数组 哈希表 矩阵 👍 101 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class TicTacToe {

    int n;
    char[][] tt;

    public TicTacToe(int n) {
        this.n = n;
        tt = new char[n][n];
    }

    /**
     * 实际上这道题就 四种 赢的情况
     * 1：同一行； 2：同一列； 3：右斜对角线；4：左斜对角线
     * 每次move 操作都会落在r,l上，那每次就判断r,l 所在的 行，列，对角线上的每个点是否和r,l所在的棋子一样
     *
     * @param row
     * @param col
     * @param player
     * @return
     */
    public int move(int row, int col, int player) {
        tt[row][col] = player == 1 ? 'X' : 'O';
        if (hasWin(row, col)) {
            return player == 1 ? 1 : 2;
        }
        return 0;
    }

    private boolean hasWin(int r, int c) {
        boolean aa = true;
        for (int i = 0; i < n; i++) {
            if (tt[r][c] != tt[r][i]) {
                aa = false;
                break;
            }
        }

        boolean bb = true;
        for (int i = 0; i < n; i++) {
            if (tt[r][c] != tt[i][c]) {
                bb = false;
                break;
            }
        }


        boolean cc = true;
        for (int i = 0; i < n; i++) {
            if (tt[r][c] != tt[i][i]) {
                cc = false;
                break;
            }
        }

        boolean dd = true;
        for (int i = n - 1; i > -1; i--) {
            if (tt[r][c] != tt[n - 1 - i][i]) {
                dd = false;
                break;
            }
        }

        return aa || bb || cc || dd;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
//leetcode submit region end(Prohibit modification and deletion)
