/*
 * @lc app=leetcode.cn id=1005 lang=javascript
 *
 * [1005] K 次取反后最大化的数组和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var largestSumAfterKNegations = function(nums, k) {
    let freq = new Map();
    
    for (let num of nums) {
        freq.set(num, (freq.get(num) || 0) + 1);
    }

    for (let i = -100; i < 0 && k > 0; i++) {
        if (freq.has(i)) {
            let t = Math.min(freq.get(i), k);
            k -= t;
            freq.set(i, freq.get(i) - t);
            freq.set(-i, (freq.get(-i) || 0) + t);
        }
    }

    if (k > 0 && k % 2 === 1 && !freq.has(0)) {
        for (let i = 1; i <= 100; i++) {
            if (freq.has(i)) {
                freq.set(i, freq.get(i) - 1);
                freq.set(-i, (freq.get(-i) || 0) + 1);
                break;
            }
        }
    }

    let sum = 0;
    for (let [key, value] of freq) {
        sum += key * value;
    }

    return sum;
};
// @lc code=end

