/*
 * @lc app=leetcode.cn id=1319 lang=javascript
 *
 * [1319] 连通网络的操作次数
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number[][]} connections
 * @return {number}
 */
var makeConnected = function(n, connections) {
    // 1. 线不够，直接返回 -1
    if (connections.length < n - 1) return -1;

    // 2. 建图
    const graph = Array.from({ length: n }, () => []);

    for (let [a, b] of connections) {
        graph[a].push(b);
        graph[b].push(a);
    }

    // 3. 访问数组
    const visited = new Array(n).fill(false);

    // 4. DFS
    function dfs(node) {
        visited[node] = true;
        for (let next of graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    // 5. 统计连通块
    let components = 0;

    for (let i = 0; i < n; i++) {
        if (!visited[i]) {
            dfs(i);
            components++;
        }
    }

    // 6. 返回答案
    return components - 1;
};
// @lc code=end

