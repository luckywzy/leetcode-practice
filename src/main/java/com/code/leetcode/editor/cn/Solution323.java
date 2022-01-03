package com.code.leetcode.editor.cn;

//给定编号从 0 到 n-1 的 n 个节点和一个无向边列表（每条边都是一对节点），请编写一个函数来计算无向图中连通分量的数目。 
//
// 示例 1: 
//
// 输入: n = 5 和 edges = [[0, 1], [1, 2], [3, 4]]
//
//     0          3
//     |          |
//     1 --- 2    4 
//
//输出: 2
// 
//
// 示例 2: 
//
// 输入: n = 5 和 edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
//
//     0           4
//     |           |
//     1 --- 2 --- 3
//
//输出:  1
// 
//
// 注意: 
//你可以假设在 edges 中不会出现重复的边。而且由于所以的边都是无向边，[0, 1] 与 [1, 0] 相同，所以它们不会同时在 edges 中出现。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 120 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution323 {

    /**
     * 广度优先
     * 也是先建立一个双向的边列表，和visit 数组，再加上一个队列
     * 然后遍历节点数，0...n-1 ,
     *  如果0 没有被访问过，把 0 加入 队列中，连通分量加1
     *      如果队列不为空，弹出队列头部元素，将其设置为已访问，获取与0 连接的点，如果其没有被访问过，将其加入队列
     * @param n
     * @param edges
     * @return
     */
    public int countComponents2(int n, int[][] edges) {
        List<List<Integer>> edList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            edList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            edList.get(edge[0]).add(edge[1]);
            edList.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                queue.offer(i);
                cnt++;
                while (!queue.isEmpty()) {
                    Integer key = queue.poll();
                    visited[key] = true;
                    List<Integer> vals = edList.get(key);
                    for (Integer v : vals) {
                        if (!visited[v]) {
                            queue.add(v);
                        }
                    }
                }
            }
        }

        return cnt;
    }


    /**
     * 深度优先
     * 首先根据 edges 生成一个双向的 图；
     * 根据节点数n 遍历 这个双向的图；
     * 1、如果当前节点没有连接任何其他节点，即edges 里面都没这个节点，则 连通分量 加 1，遍历下一个节点
     * 2、如果当前节点未访问过，则标记连通分量加1， 然后遍历所有跟当前节点链接的节点，并把当前节点标记为已访问
     *
     * @param n
     * @param edges
     * @return
     */
    public int countComponents1(int n, int[][] edges) {

        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> edMap = new HashMap<>();
        for (int[] edge : edges) {
            edMap.compute(edge[0], (key, oldVal) -> {
                if (oldVal == null) {
                    oldVal = new ArrayList<>();
                }
                oldVal.add(edge[1]);
                return oldVal;
            });
            edMap.compute(edge[1], (key, oldVal) -> {
                if (oldVal == null) {
                    oldVal = new ArrayList<>();
                }
                oldVal.add(edge[0]);
                return oldVal;
            });
        }

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            List<Integer> values = edMap.get(i);
            if (values == null) {
                cnt++;
                continue;
            }
            if (!visited[i]) {
                cnt++;
                dfs(i, values, visited, edMap);
            }
        }

        return cnt;
    }

    private void dfs(int a, List<Integer> value, boolean[] visited, Map<Integer, List<Integer>> edMap) {
        visited[a] = true;
        for (Integer b : value) {
            if (!visited[b]) {
                dfs(b, edMap.get(b), visited, edMap);
            }
        }
    }

    /**
     * 并查集解法
     *
     * @param n
     * @param edges
     * @return
     */
    public int countComponents(int n, int[][] edges) {

        Union union = new Union(n);
        for (int[] edge : edges) {
            union.merge(edge[0], edge[1]);
        }
        return union.unit;
    }

    static class Union {
        int[] root;
        //集合数
        int unit;
        //节点数
        int n;


        public Union(int n) {
            this.n = n;
            this.unit = n;
            this.root = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
        }


        public int findRoot(int x) {
            return root[x] == x ? x : (root[x] = findRoot(root[x]));
        }

        public void merge(int a, int b) {
            int aa = findRoot(a);
            int bb = findRoot(b);
            if (aa == bb) {
                return;
            }
            //合并
            root[aa] = bb;
            unit = unit - 1;
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)
