/*
 * @lc app=leetcode.cn id=851 lang=javascript
 *
 * [851] 喧闹和富有
 */

// @lc code=start
/**
 * @param {number[][]} richer
 * @param {number[]} quiet
 * @return {number[]}
 */
var loudAndRich = function(richer, quiet) {
    let n = quiet.length;
    let graph = Array.from({ length: n }, () => []);
    let indegree = Array(n).fill(0);
    let result = Array(n).fill(0);

    for (let [a, b] of richer) {
        graph[a].push(b);
        indegree[b]++;
    }

    for (let i = 0; i < n; i++) {
        result[i] = i;
    }

    let queue = [];
    for (let i = 0; i < n; i++) {
        if (indegree[i] === 0) {
            queue.push(i);
        }
    }

    while (queue.length > 0) {
        let person = queue.shift();
        
        for (let neighbor of graph[person]) {
            if (quiet[result[person]] < quiet[result[neighbor]]) {
                result[neighbor] = result[person];
            }
            indegree[neighbor]--;
            if (indegree[neighbor] === 0) {
                queue.push(neighbor);
            }
        }
    }

    return result;
};
// @lc code=end

