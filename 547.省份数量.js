/*
 * @lc app=leetcode.cn id=547 lang=javascript
 *
 * [547] 省份数量
 */

// @lc code=start
/**
 * @param {number[][]} isConnected
 * @return {number}
 */
var findCircleNum = function(isConnected) {
    let dfs = function(isConnected, visited, n, i) {
        for (let j = 0; j < n; j++) {
            if (isConnected[i][j] === 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, n, j);
            }
        }
    }

    let n = isConnected.length;
    let visited = Array(n).fill(false);
    let res = 0;
    for (let i = 0; i < n; i ++) {
        if (!visited[i]) {
            dfs(isConnected, visited, n, i);
            res++;
        }
    }
    return res;
};
// @lc code=end

