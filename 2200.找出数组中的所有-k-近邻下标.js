/*
 * @lc app=leetcode.cn id=2200 lang=javascript
 *
 * [2200] 找出数组中的所有 K 近邻下标
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} key
 * @param {number} k
 * @return {number[]}
 */
var findKDistantIndices = function(nums, key, k) {
    const res = [];
    let lastRight = -1;
    const n = nums.length;

    for (let i = 0; i < n; i++) {
        if (nums[i] === key) {
            const l = Math.max(lastRight + 1, i - k);
            const r = Math.min(n - 1, i + k);
            for (let j = l; j <= r; j++) {
                res.push(j);
            }
            lastRight = r;
        }
    }
    return res;
};
// @lc code=end

