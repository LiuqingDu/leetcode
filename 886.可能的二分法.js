/*
 * @lc app=leetcode.cn id=886 lang=javascript
 *
 * [886] 可能的二分法
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number[][]} dislikes
 * @return {boolean}
 */
var possibleBipartition = function(n, dislikes) {

    dislikes.sort((a, b) => a[0] === b[0] ? a[1] - b[1] : a[0] - b[0]);

    let graph = Array.from(Array(n + 1), () => []);
    
    for (let dis of dislikes) {
        graph[dis[0]].push(dis[1]);
        graph[dis[1]].push(dis[0]);
    }

    let res = Array(n + 1).fill(false);
    let visited = Array(n + 1).fill(false);
    let ok = true;

    let traversal = function(i) {
        if (!ok) {
            return;
        }

        visited[i] = true;

        for (let next of graph[i]) {
            if (!visited[next]) {
                res[next] = !res[i];
                traversal(next);
            } else {
                if (res[next] === res[i]) {
                    ok = false;
                    return;
                }
            }
        }
    }

    for (let i = 1; i <= n; i++) {
        if (!visited[i]) {
            traversal(i);
        }
    }

    return ok;

};
// @lc code=end

