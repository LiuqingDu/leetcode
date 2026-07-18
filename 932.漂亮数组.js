/*
 * @lc app=leetcode.cn id=932 lang=javascript
 *
 * [932] 漂亮数组
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number[]}
 */
const memo = new Map();
var beautifulArray = function(n) {
    
    // 如果缓存中已有结果，直接返回
    if (memo.has(n)) {
        return memo.get(n);
    }

    // 基础情况：n = 1 时，直接返回 [1]
    if (n === 1) {
        return [1];
    }

    const res = [];
    
    // 1. 生成左半部分的奇数：来自长度为 Math.floor((n + 1) / 2) 的漂亮数组
    for (const x of beautifulArray(Math.floor((n + 1) / 2))) {
        res.push(2 * x - 1);
    }
    
    // 2. 生成右半部分的偶数：来自长度为 Math.floor(n / 2) 的漂亮数组
    for (const x of beautifulArray(Math.floor(n / 2))) {
        res.push(2 * x);
    }

    // 存入缓存并返回
    memo.set(n, res);
    return res;
};
// @lc code=end

