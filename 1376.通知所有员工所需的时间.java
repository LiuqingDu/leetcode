/*
 * @lc app=leetcode.cn id=1376 lang=java
 *
 * [1376] 通知所有员工所需的时间
 */

// @lc code=start
class Solution {
    // 邻接表：存每个领导的下属
    List<Integer>[] tree;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        // 建树
        tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        // manager[i] -> i
        for (int i = 0; i < n; i++) {

            // 跳过老板
            if (manager[i] != -1) {
                tree[manager[i]].add(i);
            }
        }

        // 从老板开始DFS
        return dfs(headID, informTime);
    }

    // 返回：当前员工通知完所有下属所需时间
    private int dfs(int cur, int[] informTime) {

        int max = 0;

        // 遍历所有下属
        for (int next : tree[cur]) {

            // 找最慢的那条路径
            max = Math.max(max, dfs(next, informTime));
        }

        // 当前员工通知时间 + 下属最慢时间
        return informTime[cur] + max;
    }
}
// @lc code=end

