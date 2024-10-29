/*
 * @lc app=leetcode.cn id=417 lang=java
 *
 * [417] 太平洋大西洋水流问题
 */

// @lc code=start
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // 如果一个格子的雨水可以流到海里，那么它反过来也可以从海里回到格子里
        // 只需要回到格子的时候满足相邻格子大于等于当前格子高度即可
        // 从两片海域出发找到可以到达的格子，它们的交集就是最终结果

        List<List<Integer>> res = new ArrayList();
        int m = heights.length;
        int n = heights[0].length;

        boolean canReachP[][] = new boolean[m][n];
        boolean canReachA[][] = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, canReachP, i, 0);
            dfs(heights, canReachA, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, canReachP, 0, j);
            dfs(heights, canReachA, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachP[i][j] && canReachA[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] heights, boolean[][] canReach, int i, int j) {
        int m = heights.length;
        int n = heights[0].length;

        // 如果这个格子已经确认了可以流到则直接返回
        // 这个格子的周围是之前已经检查过的了
        if (canReach[i][j]) {
            return;
        }

        // 遍历到的格子都是海水可以流到的格子
        canReach[i][j] = true;

        // 这里在调用 dfs 之前就已经判断了是可以流到下一个格子的
        if (i - 1 >= 0 && heights[i - 1][j] >= heights[i][j]) {
            dfs(heights, canReach, i - 1, j);
        }
        if (j - 1 >= 0 && heights[i][j - 1] >= heights[i][j]) {
            dfs(heights, canReach, i, j - 1);
        }
        if (i + 1 < m && heights[i + 1][j] >= heights[i][j]) {
            dfs(heights, canReach, i + 1, j);
        }
        if (j + 1 < n && heights[i][j + 1] >= heights[i][j]) {
            dfs(heights, canReach, i, j + 1);
        }
    }
}
// @lc code=end

