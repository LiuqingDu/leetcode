/*
 * @lc app=leetcode.cn id=310 lang=javascript
 *
 * [310] 最小高度树
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number[][]} edges
 * @return {number[]}
 */
var findMinHeightTrees = function(n, edges) {
    if (n === 1) {
        return [0];
    }

    let degree = new Array(n).fill(0);
    let map = Array.from(Array(n), () => []);

    for (let edge of edges) {
        let a = edge[0], b = edge[1];
        degree[a]++;
        degree[b]++;

        map[a].push(b);
        map[b].push(a);
    }

    let queue = [];
    for (let i = 0; i < n; i++) {
        if (degree[i] === 1) {
            queue.push(i);
        }
    }

    let res = [];
    while(queue.length) {
        res = [];
        let size = queue.length;
        for (let i = 0; i < size; i++) {
            let cur = queue.shift();
            res.push(cur);
            for (let neighbor of map[cur]) {
                degree[neighbor]--;
                if (degree[neighbor] === 1) {
                    queue.push(neighbor);
                }
            }
        }
    }

    return res;

};
// @lc code=end

