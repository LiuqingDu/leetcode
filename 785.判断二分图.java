/*
 * @lc app=leetcode.cn id=785 lang=java
 *
 * [785] 判断二分图
 */

// @lc code=start
class Solution {

    boolean res = true;
    boolean[] color;
    boolean[] visit;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new boolean[n];
        visit = new boolean[n];

        for (int v = 0; v < n; v++) {
            if (!visit[v]) {
                traverse(graph, v);
            }
        }
        
        return res;
    }

    private void traverse(int[][] graph, int v) {
        if (!res) {
            return;
        }

        visit[v] = true;
        for (int next: graph[v]) {
            if (!visit[next]) {
                color[next] = !color[v];
                traverse(graph, next);
            } else {
                if (color[next] == color[v]) {
                    res = false;
                }
            }
        }
    }
}
// @lc code=end

