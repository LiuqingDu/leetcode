/*
 * @lc app=leetcode.cn id=888 lang=javascript
 *
 * [888] 公平的糖果交换
 */

// @lc code=start
/**
 * @param {number[]} aliceSizes
 * @param {number[]} bobSizes
 * @return {number[]}
 */
var fairCandySwap = function(aliceSizes, bobSizes) {
    let set = new Set();
    let diff = 0;

    for (let a of aliceSizes) {
        set.add(a);
        diff += a;
    }

    for (let b of bobSizes) {
        diff -= b;
    }

    diff = diff / 2;
    for (let b of bobSizes) {
        if (set.has(b + diff)) {
            return [b + diff, b];
        }
    }

    return [];
};
// @lc code=end

