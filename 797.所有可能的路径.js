/*
 * @lc app=leetcode.cn id=797 lang=javascript
 *
 * [797] 所有可能的路径
 */

// @lc code=start
/**
 * @param {number[][]} graph
 * @return {number[][]}
 */
var allPathsSourceTarget = function(graph) {

    let n = graph.length;

    let res = [];
    let path = [];

    let reversal = function(path, i) {
        if (i === n - 1) {
            res.push([...path]);
            return;
        }

        for (let next of graph[i]) {
            path.push(next);
            reversal(path, next);
            path.pop();
        }
    }

    path.push(0);
    reversal(path, 0);
    return res;

};
// @lc code=end

