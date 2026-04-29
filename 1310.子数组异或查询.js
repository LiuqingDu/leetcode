/*
 * @lc app=leetcode.cn id=1310 lang=javascript
 *
 * [1310] 子数组异或查询
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @param {number[][]} queries
 * @return {number[]}
 */
var xorQueries = function(arr, queries) {
    const prefix = [0]; // prefix[0] = 0
    
    // 构建前缀异或
    for (let num of arr) {
        prefix.push(prefix[prefix.length - 1] ^ num);
    }
    
    // 直接算答案
    return queries.map(([L, R]) => {
        return prefix[R + 1] ^ prefix[L];
    });
};
// @lc code=end

