/*
 * @lc app=leetcode.cn id=3364 lang=javascript
 *
 * [3364] 最小正和子数组
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} l
 * @param {number} r
 * @return {number}
 */
var minimumSumSubarray = function(nums, l, r) {
    
    let a = nums.map((a) => a);
    let res = Number.MAX_SAFE_INTEGER;
    for (let i = 0; i <= a.length - l; i++) {
        let s = 0;
        for (let j = i; j < a.length && j - i + 1 <= r; j++) {
            s += a[j];
            if (s > 0 && j - i + 1 >= l) {
                res = Math.min(res, s);
            }
        }
    }
    return res === Number.MAX_SAFE_INTEGER ? -1 : res;
};
// @lc code=end

