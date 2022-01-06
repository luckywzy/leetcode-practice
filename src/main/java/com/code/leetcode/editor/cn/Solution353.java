package com.code.leetcode.editor.cn;

//请你设计一个 贪吃蛇游戏，该游戏将会在一个 屏幕尺寸 = 宽度 x 高度 的屏幕上运行。如果你不熟悉这个游戏，可以 点击这里 在线试玩。 
//
// 起初时，蛇在左上角的 (0, 0) 位置，身体长度为 1 个单位。 
//
// 你将会被给出一个数组形式的食物位置序列 food ，其中 food[i] = (ri, ci) 。当蛇吃到食物时，身子的长度会增加 1 个单位，得分也会 
//+1 。 
//
// 食物不会同时出现，会按列表的顺序逐一显示在屏幕上。比方讲，第一个食物被蛇吃掉后，第二个食物才会出现。 
//
// 当一个食物在屏幕上出现时，保证 不会 出现在被蛇身体占据的格子里。 
//
// 如果蛇越界（与边界相撞）或者头与 移动后 的身体相撞（即，身长为 4 的蛇无法与自己相撞），游戏结束。 
//
// 实现 SnakeGame 类： 
//
// 
// SnakeGame(int width, int height, int[][] food) 初始化对象，屏幕大小为 height x width ，食物
//位置序列为 food 
// int move(String direction) 返回蛇在方向 direction 上移动后的得分。如果游戏结束，返回 -1 。 
// 
// 
//
// 示例 1： 
//
// 
//输入：
//["SnakeGame", "move", "move", "move", "move", "move", "move"]
//[[3, 2, [[1, 2], [0, 1]]], ["R"], ["D"], ["R"], ["U"], ["L"], ["U"]]
//输出：
//[null, 0, 0, 1, 1, 2, -1]
//
//解释：
//SnakeGame snakeGame = new SnakeGame(3, 2, [[1, 2], [0, 1]]);
//snakeGame.move("R"); // 返回 0
//snakeGame.move("D"); // 返回 0
//snakeGame.move("R"); // 返回 1 ，蛇吃掉了第一个食物，同时第二个食物出现在 (0, 1)
//snakeGame.move("U"); // 返回 1
//snakeGame.move("L"); // 返回 2 ，蛇吃掉了第二个食物，没有出现更多食物
//snakeGame.move("U"); // 返回 -1 ，蛇与边界相撞，游戏结束
// 
//
// 
//
// 提示： 
//
// 
// 1 <= width, height <= 10⁴ 
// 1 <= food.length <= 50 
// food[i].length == 2 
// 0 <= ri < height 
// 0 <= ci < width 
// direction.length == 1 
// direction is 'U', 'D', 'L', or 'R'. 
// 最多调用 10⁴ 次 move 方法 
// 
// Related Topics 设计 队列 数组 矩阵 👍 65 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class SnakeGame {

    int width;
    int height;
    int[][] food;

    Deque<P> snakeBody = new LinkedList<>();

    int eatCnt = 0;

    int bodyLen = 1;

    class P {
        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x;
        int y;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof P)) return false;
            P p = (P) o;
            return x == p.x &&
                    y == p.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }


    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        snakeBody.addFirst(new P(0,0));
    }

    public int move(String direction) {
        P last = snakeBody.getFirst();
        P p = last;

        if ("R".equals(direction)) {
            if (last.y + 1 >= width) {
                return -1;
            }
            p = new P(last.x, last.y + 1);
        } else if ("D".equals(direction)) {
            if (last.x + 1 >= height) {
                return -1;
            }
            p = new P(last.x + 1, last.y);

        } else if ("U".equals(direction)) {
            if (last.x - 1 < 0) {
                return -1;
            }
            p = new P(last.x - 1, last.y);
        } else if ("L".equals(direction)) {
            if (last.y - 1 < 0) {
                return -1;
            }
            p = new P(last.x, last.y - 1);
        }

        if (hasFood(p.x, p.y)) {
            eatCnt++;
            bodyLen++;
        }else {
            snakeBody.pollLast();
        }
        //撞自己身上了
        if(snakeBody.contains(p)){
            return -1;
        }
        snakeBody.addFirst(p);

        return eatCnt;
    }

    private boolean hasFood(int x, int y) {
        int i = 0;
        for (int[] f : food) {
            if (i == eatCnt) {
                if (f[0] == x && f[1] == y) {
                    return true;
                } else {
                    break;
                }
            }
            i++;
        }
        return false;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
//leetcode submit region end(Prohibit modification and deletion)
