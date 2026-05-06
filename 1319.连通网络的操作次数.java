/*
 * @lc app=leetcode.cn id=1319 lang=java
 *
 * [1319] 连通网络的操作次数
 */

// @lc code=start
class Solution {
    public int makeConnected(int n, int[][] connections) {
        // 1. 边不够直接不可能
        if (connections.length < n - 1) {
            return -1;
        }

        // 2. 建图（邻接表）
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] c : connections) {
            graph.get(c[0]).add(c[1]);
            graph.get(c[1]).add(c[0]);
        }

        // 3. DFS访问数组
        boolean[] visited = new boolean[n];

        int components = 0;

        // 4. 统计连通块
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited);
                components++;
            }
        }

        // 5. 答案
        return components - 1;
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(next, graph, visited);
            }
        }
    }
}
// @lc code=end

