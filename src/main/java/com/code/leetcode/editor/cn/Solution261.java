package com.code.leetcode.editor.cn;

//给定从 0 到 n-1 标号的 n 个结点，和一个无向边列表（每条边以结点对来表示），请编写一个函数用来判断这些边是否能够形成一个合法有效的树结构。 
//
// 示例 1： 
//
// 输入: n = 5, 边列表 edges = [[0,1], [0,2], [0,3], [1,4]]
//输出: true 
//
// 示例 2: 
//
// 输入: n = 5, 边列表 edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
//输出: false 
//
// 注意：你可以假定边列表 edges 中不会出现重复的边。由于所有的边是无向边，边 [0,1] 和边 [1,0] 是相同的，因此不会同时出现在边列表 edg
//es 中。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 
// 👍 117 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution261 {

    /**
     * 无向图的连通性可以用并查集计算：https://www.cnblogs.com/noKing/p/8018609.html
     * 树的入度加出度一定等于2*(n-1),n 为节点数：https://blog.csdn.net/i4053/article/details/84190926
     *
     * @param n
     * @param edges
     * @return
     */
    public boolean validTree(int n, int[][] edges) {
        /**
         * index 0 入度
         * index 1 出度
         */
        int[][] linkCnt = new int[n][2];
        int[] conn = new int[n];
        for (int i = 0; i < n; i++) {
            conn[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            int nod1 = edges[i][0];
            int nod2 = edges[i][1];

            int index = Math.min(nod1, nod2);
            int group = conn[Math.max(nod1, nod2)];
            int preGroup = conn[index];
            //conn[index]= group;
            for (int j = 0; j < conn.length; j++) {
                if (conn[j] == preGroup) {
                    conn[j] = group;
                }
            }

            //出
            linkCnt[nod1][1] += 1;
            //入
            linkCnt[nod2][0] += 1;

        }
        int total = 0;
        for (int[] ints : linkCnt) {
            total += ints[0] + ints[1];
        }
        if (Arrays.stream(conn).distinct().count() > 1) {
            return false;
        }

        return total == 2 * (n - 1);
    }


    /**
     * 使用邻接表判断无向图的连通性，使用DFS遍历无向图，使用visited[] 标识此点是否遍历过，如果存在未遍历的节点，则表明此图不连通
     * 同时边的数目 + 1 应该等于 节点数n
     *
     * @param n
     * @param edges
     * @return
     */
    public boolean validTree1(int n, int[][] edges) {
        //边的数目+1 需要等于 n
        if (edges.length + 1 != n) {
            return false;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>(n);
        boolean[] visited = new boolean[n];
        //构造邻接表
        for (int[] edge : edges) {
            push(graph, edge, 0, 1);
            push(graph, edge, 1, 0);
        }
        dfs(graph, 0, visited);

        for (boolean visit : visited) {
            if (!visit) {
                return false;
            }
        }
        return true;
    }



    private void dfs(Map<Integer, List<Integer>> graph, int i, boolean[] visited) {
        if (visited[i]) return;
        visited[i] = true;
        for (Integer node : graph.getOrDefault(i, Collections.emptyList())) {
            dfs(graph, node, visited);
        }
    }

    public boolean validTree2(int n, int[][] edges) {
        //边的数目+1 需要等于 n
        if (edges.length + 1 != n) {
            return false;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>(n);
        boolean[] visited = new boolean[n];
        //构造邻接表
        for (int[] edge : edges) {
            push(graph, edge, 0, 1);
            push(graph, edge, 1, 0);
        }
        return bfs(graph, visited);
    }

    private void push(Map<Integer, List<Integer>> graph, int[] edge, int i, int i2) {
        graph.computeIfPresent(edge[i], (key, oldVal) -> {
            oldVal.add(edge[i2]);
            return oldVal;
        });
        graph.computeIfAbsent(edge[i], key -> {
            List<Integer> val = new ArrayList<>();
            val.add(edge[i2]);
            return val;
        });
    }

    private boolean bfs(Map<Integer, List<Integer>> graph, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        visited[0] = true;
        while (!q.isEmpty()){
            Integer node = q.poll();
            visited[node] = true;
            for (Integer linkedNode : graph.getOrDefault(node, Collections.emptyList())) {
                if(visited[linkedNode]){
                    continue;
                }
                q.add(linkedNode);
            }
        }
        for (boolean v : visited) {
            if(!v){
                return false;
            }
        }

        return true;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
