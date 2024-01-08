/*
 * @lc app=leetcode.cn id=785 lang=javascript
 *
 * [785] 判断二分图
 */

// @lc code=start
/**
 * @param {number[][]} graph
 * @return {boolean}
 */
var isBipartite = function(graph) {

    let n = graph.length;
    let color = Array(n).fill(false);
    let visited= Array(n).fill(false);

    let res = true;

    let traversal = function(graph, i) {
        if (!res) {
            return;
        }

        visited[i] = true;
        for (next of graph[i]) {
            if (!visited[next]) {
                color[next] = !color[i];
                traversal(graph, next);
            } else {
                if (color[next] === color[i]) {
                    res = false;
                    return;
                }
            }
        }
    }

    for (let i = 0; i < n; i++) {
        if (!visited[i]) {
            traversal(graph, i);
        }
    }

    return res;
};
// @lc code=end

