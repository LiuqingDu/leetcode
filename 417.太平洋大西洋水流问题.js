/*
 * @lc app=leetcode.cn id=417 lang=javascript
 *
 * [417] 太平洋大西洋水流问题
 */

// @lc code=start
/**
 * @param {number[][]} heights
 * @return {number[][]}
 */
var pacificAtlantic = function(heights) {
    let dfs = function(heights, canReach, i, j) {
        let m = heights.length;
        let n = heights[0].length;

        if (canReach[i][j]) {
            return;
        }

        canReach[i][j] = true;

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

    let res = [];
    let m = heights.length;
    let n = heights[0].length;

    let canReachP = Array.from(Array(m), () => Array(n).fill(false));
    let canReachA = Array.from(Array(m), () => Array(n).fill(false));

    for (let i = 0; i < m; i++) {
        dfs(heights, canReachP, i, 0);
        dfs(heights, canReachA, i, n - 1);
    }

    for (let j = 0; j < n; j++) {
        dfs(heights, canReachP, 0, j);
        dfs(heights, canReachA, m - 1, j);
    }

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (canReachP[i][j] && canReachA[i][j]) {
                res.push([i, j]);
            }
        }
    }

    return res;
};
// @lc code=end

