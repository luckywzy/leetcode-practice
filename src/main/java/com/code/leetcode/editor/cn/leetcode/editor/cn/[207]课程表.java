package com.code.leetcode.editor.cn.leetcode.editor.cn;
//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。 
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 1895 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution207 {
    /**
     * 课程的前后置顺序刚好可以排成一个有向无环图。
     * 那么如果有环，说明无法完成
     * 如果按照前后顺序学不完，无法完成
     *
     * BFS
     * 1、给课程生成 邻接表
     * 2、每个课程计算入度
     * 2、从哪儿开始学，从入度为 0 的课程开始学，将入度==0 的课程放到队列中
     * 3、遍历 入度为 0 的课程
     *      1、numCourses --
     *      2、去邻接表里查后续课程，将后续课程的入度－1（前置课程已经学了嘛），如果后续课程入度为 0，将其加入 队列
     * 4、return numCourses == 0
     *
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<List<Integer>>();
        //入度
        int[] indegree = new int[numCourses];
        //入度为 0 的课程
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) //入度为 0
            {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer pre = queue.poll();
            numCourses--;
            List<Integer> postList = adj.get(pre);
            for (Integer cur : postList) {
                //前置课程如果已经学完了，就可以加入到入度为 0 的列表中了
                if (-- indegree[cur] == 0) {
                    queue.add(cur);
                }
            }
        }

        return numCourses == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
