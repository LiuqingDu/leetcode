/*
 * @lc app=leetcode.cn id=1023 lang=javascript
 *
 * [1023] 驼峰式匹配
 */

// @lc code=start
/**
 * @param {string[]} queries
 * @param {string} pattern
 * @return {boolean[]}
 */
var camelMatch = function(queries, pattern) {
    let n = queries.length
    let res = new Array(n)
    for (let i = 0; i < n; i++) {
        res[i] = true
        let p = 0
        for (let j = 0; j < queries[i].length; j++) {
            let c = queries[i][j]
            if (p < pattern.length && pattern[p] === c) {
                p++
            } else if (c.toUpperCase() === c) {
                res[i] = false
                break
            }
        }
        if (p < pattern.length) {
            res[i] = false
        }
    }
    return res
};
// @lc code=end

