/*
 * @lc app=leetcode.cn id=802 lang=java
 *
 * [802] 找到最终的安全状态
 */

// @lc code=start
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // 若起始节点位于一个环内，或者能到达一个环，则该节点不是安全的。否则，该节点是安全的
        // 0 表示未访问过
        // 1 表示正在访问,或者处于环中
        // 3 表示访问过,且是安全的
        // 当第一次访问时标记为 1, 然后访问与它相连的点, 如果途中遇到了 1, 说明遇到了环
        // 此时保持它依然是 1, 这样环的信息就会传递开
        // 如果没有遇到 1, 则改为 2
        
        int n = graph.length;
        int[] color = new int[n];
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (safe(graph, color, i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean safe(int[][] graph, int[] color, int x) {
        if (color[x] > 0) {
            return color[x] == 2;
        }
        color[x] = 1;
        for (int y : graph[x]) {
            if (!safe(graph, color, y)) {
                return false;
            }
        }
        color[x] = 2;
        return true;
    }
}
// @lc code=end

