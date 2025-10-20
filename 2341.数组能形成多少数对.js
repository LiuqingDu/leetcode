/*
 * @lc app=leetcode.cn id=2341 lang=javascript
 *
 * [2341] 数组能形成多少数对
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var numberOfPairs = function(nums) {
    const map = new Map();

    for (const num of nums) {
        map.set(num, (map.get(num) || 0) + 1);
    }

    let pairs = 0;
    let leftovers = 0;
    for (const count of map.values()) {
        pairs += Math.floor(count / 2);
        leftovers += count % 2;
    }

    return [pairs, leftovers];
};
// @lc code=end

