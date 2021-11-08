package com.code.leetcode.editor.cn;

//假设你是一个专业的狗仔，参加了一个 n 人派对，其中每个人被从 0 到 n - 1 标号。在这个派对人群当中可能存在一位 “名人”。所谓 “名人” 的定义是
//：其他所有 n - 1 个人都认识他/她，而他/她并不认识其他任何人。 
//
// 现在你想要确认这个 “名人” 是谁，或者确定这里没有 “名人”。而你唯一能做的就是问诸如 “A 你好呀，请问你认不认识 B呀？” 的问题，以确定 A 是否
//认识 B。你需要在（渐近意义上）尽可能少的问题内来确定这位 “名人” 是谁（或者确定这里没有 “名人”）。 
//
// 在本题中，你可以使用辅助函数 bool knows(a, b) 获取到 A 是否认识 B。请你来实现一个函数 int findCelebrity(n)。 
//
//
// 派对最多只会有一个 “名人” 参加。若 “名人” 存在，请返回他/她的编号；若 “名人” 不存在，请返回 -1。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: graph = [
//  [1,1,0],
//  [0,1,0],
//  [1,1,1]
//]
//输出: 1
//解释: 有编号分别为 0、1 和 2 的三个人。graph[i][j] = 1 代表编号为 i 的人认识编号为 j 的人，而 graph[i][j] = 0
// 则代表编号为 i 的人不认识编号为 j 的人。“名人” 是编号 1 的人，因为 0 和 2 均认识他/她，但 1 不认识任何人。
// 
//
// 示例 2: 
//
// 
//
// 
//输入: graph = [
//  [1,0,1],
//  [1,1,0],
//  [0,1,1]
//]
//输出: -1
//解释: 没有 “名人”
// 
//
// 
//
// 提示： 
//
// 
// n == graph.length 
// n == graph[i].length 
// 2 <= n <= 100 
// graph[i][j] 是 0 或 1. 
// graph[i][i] == 1 
// 
//
// 
//
// 进阶：如果允许调用 API knows 的最大次数为 3 * n ，你可以设计一个不超过最大调用次数的解决方案吗？ 
//
// 
// 
// Related Topics 贪心 图 双指针 交互 👍 163 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

import java.util.ArrayList;
import java.util.List;

public class Solution277 extends Relation {

    public Solution277(int[][] g) {
        super(g);
    }

    /**
     * 1、名人不认识其他人 所以名人那一行，除g[k][k] == 1 外其他都是0
     * 2、其他人认识名人，例如名人是 k , 当前用户为i，那么 g[k][i] ==0 , g[i][k] == 1
     * 所以：扫描到第 K 行时，除g[k][k] == 1 外其他都是0，且对于其他列i来说，都有  g[k][i] ==0 , g[i][k] == 1 ，此人即为名人
     *
     * @param n
     * @return
     */
    public int findCelebrity(int n) {
        for (int i = 0; i < n; i++) {
            boolean isFame = true;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                //如果出现 名人 认识 其他人 ｜｜ 其他人不认识名人，则此人不是名人
                if (knows(i, j) || !knows(j, i)) {
                    isFame = false;
                    break;
                }
            }
            if (isFame) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 进阶：双指针
     * 1、找到潜在的名人，循环l,r ，g[l][r] == 1时， l 一定不是 潜在的名人，最后 l ,r 相遇循环退出
     * 2、校验潜在的名人
     *
     * [1,1,0,0],
     * [0,1,0,0],
     * [1,1,1,0],
     * [0,1,0,1]
     *
     * @param n
     * @return
     */
    public int findCelebrity1(int n) {
        int l = 0;
        int r = n - 1;
        while (l != r) {
            if (knows(l, r)) {
                l++;
            } else {
                r--;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != l && knows(l, i)) {
                return -1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!knows(i, l)) {
                return -1;
            }
        }
        return l;
    }

}

class Relation {

    int[][] gr;

    public Relation(int[][] g) {
        gr = g;
    }

    boolean knows(int a, int b) {
        return gr[a][b] == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
