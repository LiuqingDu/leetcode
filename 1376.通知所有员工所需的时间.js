/*
 * @lc app=leetcode.cn id=1376 lang=javascript
 *
 * [1376] 通知所有员工所需的时间
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number} headID
 * @param {number[]} manager
 * @param {number[]} informTime
 * @return {number}
 */
var numOfMinutes = function(n, headID, manager, informTime) {
    // 1. 建树
    const tree = Array.from({ length: n }, () => []);

    for (let i = 0; i < n; i++) {

        // 跳过老板
        if (manager[i] !== -1) {
            tree[manager[i]].push(i);
        }
    }

    // 2. DFS
    function dfs(cur) {

        let maxTime = 0;

        // 遍历所有下属
        for (const next of tree[cur]) {

            // 找传播最慢的路径
            maxTime = Math.max(maxTime, dfs(next));
        }

        // 当前员工通知时间 + 最慢下属时间
        return informTime[cur] + maxTime;
    }

    // 从老板开始
    return dfs(headID);
};
// @lc code=end

