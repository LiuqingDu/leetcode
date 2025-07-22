/*
 * @lc app=leetcode.cn id=841 lang=java
 *
 * [841] 钥匙和房间
 */

// @lc code=start
class Solution {
    boolean[] visited;
    int count;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        visited = new boolean[n];
        count = 0;

        // 从第一个房间开始DFS
        dfs(rooms, 0);

        // 如果访问的房间数等于总房间数，则可以访问所有房间
        return count == n;
    }

    private void dfs(List<List<Integer>> rooms, int room) {
        visited[room] = true;
        count++;
        for (int key : rooms.get(room)) {
            if (!visited[key]) {
                dfs(rooms, key);
            }
        }
    }
}
// @lc code=end

