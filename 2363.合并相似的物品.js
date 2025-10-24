/*
 * @lc app=leetcode.cn id=2363 lang=javascript
 *
 * [2363] 合并相似的物品
 */

// @lc code=start
/**
 * @param {number[][]} items1
 * @param {number[][]} items2
 * @return {number[][]}
 */
var mergeSimilarItems = function(items1, items2) {
    const map = new Map();

    for (const [value, weight] of items1) {
        map.set(value, (map.get(value) || 0) + weight);
    }

    for (const [value, weight] of items2) {
        map.set(value, (map.get(value) || 0) + weight);
    }

    const result = [];
    for (const [value, weight] of map.entries()) {
        result.push([value, weight]);
    }

    result.sort((a, b) => a[0] - b[0]);
    return result;
};
// @lc code=end

