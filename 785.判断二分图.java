/*
 * @lc app=leetcode.cn id=785 lang=java
 *
 * [785] 判断二分图
 */

// @lc code=start
class Solution {

    // 二分图就是把当前节点放在一侧，与当前节点相邻的所有节点在另一侧
    // 或者理解为将当前节点标记为一种颜色，相邻的节点标记为另一种颜色
    // 如果无法实现，也就是如果有相邻的节点颜色相同，那么就不是二分图

    // 记录最终结果，默认是二分图，直到找到某一处不符合二分图的情况则记为false
    boolean res = true;
    // 记录每个节点的颜色，因为只有两种颜色，可以用boolean表示
    boolean[] color;
    // 记录当前节点是否已经标记过颜色
    boolean[] visit;

    public boolean isBipartite(int[][] graph) {
        // graph[i]是一个数组，表示与i相邻的节点集合，graph的长度为n
        int n = graph.length;
        color = new boolean[n];
        visit = new boolean[n];

        // 依次从每个节点出发DFS遍历图，因为有可能图不是一体的，而是多个部分组成，
        // 因此从单一节点出发不能完全遍历图，应当从每个节点都出发尝试
        for (int v = 0; v < n; v++) {
            // 如果该节点还没有遍历过，则遍历
            if (!visit[v]) {
                // 每次从这里调用traverse意味着是第一次进入图的一个独立部分
                // 默认起点的颜色就是color[v]的默认值，也就是假设v已经染成了默认颜色
                traverse(graph, v);
            }
        }

        return res;
    }

    // 从节点v出发遍历图graph，并尝试将节点染色
    private void traverse(int[][] graph, int v) {
        // 如果已经不是二分图了则直接退出
        if (!res) {
            return;
        }

        // 标记当前节点已遍历
        visit[v] = true;
        // 遍历当前节点相邻的所有节点
        for (int next: graph[v]) {
            // 如果这个相邻的节点还没有遍历过，则把这个节点染成与当前节点不同的颜色，然后继续遍历
            if (!visit[next]) {
                color[next] = !color[v];
                traverse(graph, next);
            } else {
                // 如果相邻节点已经染色，则判断这两个节点颜色是否不同，如果相同，说明不是二分图
                if (color[next] == color[v]) {
                    res = false;
                }
            }
        }
    }
}
// @lc code=end

