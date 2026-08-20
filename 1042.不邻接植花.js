/*
 * @lc app=leetcode.cn id=1042 lang=javascript
 *
 * [1042] 不邻接植花
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number[][]} paths
 * @return {number[]}
 */
var gardenNoAdj = function(n, paths) {
    
    let adj = new Array(n).fill(null).map(() => []);
    for (let path of paths) {
        adj[path[0] - 1].push(path[1] - 1);
        adj[path[1] - 1].push(path[0] - 1);
    }
    let ans = new Array(n).fill(0);
    for (let i = 0; i < n; i++) {
        let colored = new Array(5).fill(false);
        for (let vertex of adj[i]) {
            colored[ans[vertex]] = true;
        }
        for (let j = 1; j <= 4; j++) {
            if (!colored[j]) {
                ans[i] = j;
                break;
            }
        }
    }
    return ans;

};
// @lc code=end

