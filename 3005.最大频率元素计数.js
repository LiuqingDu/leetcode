/*
 * @lc app=leetcode.cn id=3005 lang=javascript
 *
 * [3005] 最大频率元素计数
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxFrequencyElements = function(nums) {
    let count = new Map();
    for (let a of nums) {
        count.set(a, (count.get(a) || 0) + 1);
    }

    let max = 0;
    for (let a of count.values()) {
        if (a > max) {
            max = a;
        }
    }

    let res = 0;
    for (let a of count.values()) {
        if (a === max) {
            res += a;
        }
    }

    return res;
};
// @lc code=end

