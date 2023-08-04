/*
 * @lc app=leetcode.cn id=797 lang=java
 *
 * [797] 所有可能的路径
 */

// @lc code=start

class Solution {
    // 已经说明了是无环的图，可以从起点一直开始走，直到走到目的地为止
    // 然后退回上一步从另一个方向继续走
    // 回溯方法
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    List<Integer> path = new LinkedList<Integer>();
    int[][] graph;
    int end;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        // 记录终点值
        end = graph.length - 1;
        // 先从起点开始
        path.add(0);
        travesal();
        return res;
    }

    private void travesal() {
        int last = path.get(path.size() - 1);
        // 如果路径已经走到终点则加入最终结果
        if (last == end) {
            res.add(new LinkedList<Integer>(path));
            return;
        }

        // 本次可以选择的选项
        int[] choice = graph[last];
        for (int i = 0; i < choice.length; i++) {
            // 做出选择
            path.add(choice[i]);
            travesal();
            // 撤销选择
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

