/*
 * @lc app=leetcode.cn id=1306 lang=java
 *
 * [1306] 跳跃游戏 III
 */

// @lc code=start
class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return dfs(arr, start, visited);
    }

    private boolean dfs(int[] arr, int i, boolean[] visited) {
        // 越界 或 已访问
        if (i < 0 || i >= arr.length || visited[i]) {
            return false;
        }

        // 找到0
        if (arr[i] == 0) {
            return true;
        }

        visited[i] = true;

        // 向左右跳
        return dfs(arr, i + arr[i], visited) || 
               dfs(arr, i - arr[i], visited);
    }
}
// @lc code=end

